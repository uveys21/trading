package com.uveys.trader.domain.usecase

import com.uveys.trader.domain.entity.Candle
import com.uveys.trader.domain.entity.Order
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.Position
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.domain.entity.TechnicalIndicator
import com.uveys.trader.domain.repository.BinanceRepository
import com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase.Companion.DEFAULT_CANDLE_LIMIT
import com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase.Companion.DEFAULT_INTERVAL
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.math.BigDecimal
import javax.inject.Inject
import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Singleton

@Singleton
class TripleConfirmationStrategyUseCase @Inject constructor(
    private val binanceRepository: BinanceRepository,
    private val calculateIndicatorsUseCase: CalculateIndicatorsUseCase
) {
    companion object {
        const val DEFAULT_INTERVAL = "15m"
        const val DEFAULT_CANDLE_LIMIT = 300 // 50 ve 200 EMA için yeterli veri
        const val STOP_LOSS_PERCENTAGE = 2.0 // %2
        const val TAKE_PROFIT_PERCENTAGE = 4.0 // %4
        const val MAX_RISK_PERCENTAGE = 1.0 // %1
        

    }

    /**
     * Üçlü Onaylı Trend Sistemi stratejisini uygulayan use case
     */
    
    /**
     * Stratejiyi analiz eder ve sinyal üretir
     * @param symbol Kripto para çifti
     * @return Sinyal akışı (Long, Short veya Nötr)
     */
    suspend fun analyzeStrategy(symbol: String): TradingSignal {
        // Geçmiş mum verilerini al
        val candles = binanceRepository.getKlines(symbol, DEFAULT_INTERVAL, DEFAULT_CANDLE_LIMIT)
        
        // Teknik göstergeleri hesapla
        val indicators = calculateIndicatorsUseCase.execute(candles, symbol, DEFAULT_INTERVAL)
        
        // Sinyalleri kontrol et
        return when {
            indicators.isLongSignal() -> TradingSignal.LONG
            indicators.isShortSignal() -> TradingSignal.SHORT
            else -> TradingSignal.NEUTRAL
        }
    }
    
    /**
     * Gerçek zamanlı strateji analizi yapar
     * @param symbol Kripto para çifti
     * @return Sinyal akışı
     */
    fun analyzeStrategyStream(symbol: String): Flow<TradingSignal> {
        return binanceRepository.getKlinesStream(symbol, DEFAULT_INTERVAL)
            .map { latestCandle ->
                val historicalCandles = binanceRepository.getKlines(symbol, DEFAULT_INTERVAL, DEFAULT_CANDLE_LIMIT)
                
                val allCandles = if (historicalCandles.isNotEmpty() && historicalCandles.last().openTime == latestCandle.openTime) {
                    Timber.d("Latest candle from stream has the same openTime as the last historical candle. Replacing last historical with latest.")
                    historicalCandles.dropLast(1) + latestCandle
                } else if (historicalCandles.isNotEmpty() && historicalCandles.last().openTime > latestCandle.openTime) {
                    Timber.w("Latest candle from stream (openTime: ${latestCandle.openTime}) is older than the last historical candle (openTime: ${historicalCandles.last().openTime}). Using historical candles only.")
                    historicalCandles
                } else {
                    historicalCandles + latestCandle
                }
                
                if (allCandles.isEmpty()) {
                    Timber.w("No candle data available for $symbol on $DEFAULT_INTERVAL after processing stream update.")
                    return@map TradingSignal.NEUTRAL
                }

                val indicators = calculateIndicatorsUseCase.execute(allCandles, symbol, DEFAULT_INTERVAL)
                
                when {
                    indicators.isLongSignal() -> TradingSignal.LONG
                    indicators.isShortSignal() -> TradingSignal.SHORT
                    else -> TradingSignal.NEUTRAL
                }
            }
    }

    suspend fun getAccountBalance(): BigDecimal {
        return binanceRepository.getAccountBalance()
    }

    suspend fun getOpenPositions(): List<Position> {
        return binanceRepository.getOpenPositions()
    }

    suspend fun getOrderHistory(symbol: String, limit: Int): List<Order> {
        return binanceRepository.getOrderHistory(symbol, limit)
    }


    /**
     * Otomatik işlem açar
     * @param symbol Kripto para çifti
     * @param signal İşlem sinyali
     * @param leverage Kaldıraç oranı
     */
    suspend fun executeTradeSignal(symbol: String, signal: TradingSignal, leverage: Int): TradeResult {
        if (signal == TradingSignal.NEUTRAL) {
            return TradeResult(success = false, message = "Nötr sinyal, işlem yapılmadı")
        }
        
        try {
            // Kaldıraç oranını ayarla
            binanceRepository.setLeverage(symbol, leverage)
            
            // Hesap bakiyesini al
            val balance = binanceRepository.getAccountBalance()
            
            // Risk yönetimi: Bakiyenin %1'ini riske et
            val riskAmount = balance.multiply(BigDecimal(MAX_RISK_PERCENTAGE / 100.0))
            
            // Anlık fiyatı al
            val currentPrice = binanceRepository.getPrice(symbol)
            
            // İşlem miktarını hesapla (USD cinsinden)
            val tradeAmount = riskAmount.multiply(BigDecimal(leverage))
            
            // Miktar hesabı (coin miktarı)
            val quantity = tradeAmount.divide(currentPrice, 8, BigDecimal.ROUND_DOWN)
            
            // Stop-loss ve take-profit fiyatlarını hesapla
            val stopLossPrice: BigDecimal
            val takeProfitPrice: BigDecimal
            
            val positionSide: PositionSide
            val entryOrderSide: OrderSide
            val exitOrderSide: OrderSide
            
            if (signal == TradingSignal.LONG) {
                positionSide = PositionSide.LONG
                entryOrderSide = OrderSide.BUY
                exitOrderSide = OrderSide.SELL
                
                stopLossPrice = currentPrice.multiply(
                    BigDecimal.ONE.subtract(BigDecimal(STOP_LOSS_PERCENTAGE / 100.0))
                )
                takeProfitPrice = currentPrice.multiply(
                    BigDecimal.ONE.add(BigDecimal(TAKE_PROFIT_PERCENTAGE / 100.0))
                )
            } else {
                positionSide = PositionSide.SHORT
                entryOrderSide = OrderSide.SELL
                exitOrderSide = OrderSide.BUY
                
                stopLossPrice = currentPrice.multiply(
                    BigDecimal.ONE.add(BigDecimal(STOP_LOSS_PERCENTAGE / 100.0))
                )
                takeProfitPrice = currentPrice.multiply(
                    BigDecimal.ONE.subtract(BigDecimal(TAKE_PROFIT_PERCENTAGE / 100.0))
                )
            }
            
            // Pozisyon aç
            val entryOrder = binanceRepository.createMarketOrder(
                symbol = symbol,
                side = entryOrderSide,
                positionSide = positionSide,
                quantity = quantity
            )
            
            // Stop-loss emri oluştur
            val stopLossOrder = binanceRepository.createStopLossOrder(
                symbol = symbol,
                side = exitOrderSide,
                positionSide = positionSide,
                stopPrice = stopLossPrice,
                quantity = quantity
            )
            
            // Take-profit emri oluştur
            val takeProfitOrder = binanceRepository.createTakeProfitOrder(
                symbol = symbol,
                side = exitOrderSide,
                positionSide = positionSide,
                price = takeProfitPrice,
                quantity = quantity
            )
            
            return TradeResult(
                success = true,
                message = "${signal.name} pozisyonu açıldı",
                entryOrderId = entryOrder.orderId,
                stopLossOrderId = stopLossOrder.orderId,
                takeProfitOrderId = takeProfitOrder.orderId
            )
            
        } catch (e: Exception) {
            return TradeResult(
                success = false,
                message = "İşlem hatası: ${e.message}"
            )
        }
    }
}

/**
 * İşlem sinyali enum sınıfı
 */
enum class TradingSignal {
    LONG, SHORT, NEUTRAL
}

/**
 * İşlem sonucu veri sınıfı
 */
data class TradeResult(
    val success: Boolean,
    val message: String,
    val entryOrderId: Long = 0,
    val stopLossOrderId: Long = 0,
    val takeProfitOrderId: Long = 0
)

package com.uveys.trader.domain.usecase

import com.uveys.trader.domain.entity.Order
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.Position
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.domain.repository.BinanceRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.math.BigDecimal
import javax.inject.Inject
import timber.log.Timber
import javax.inject.Singleton
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.onEach
import android.util.Log
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.merge

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
        Timber.d("Strategy stream analysis started for $symbol")
        return binanceRepository.getKlinesStream(symbol, DEFAULT_INTERVAL)
            .map { latestCandle ->
                Timber.d("Received new candle update from stream: openTime=${latestCandle.openTime}, closeTime=${latestCandle.closeTime}")
                val historicalCandles = withContext(Dispatchers.IO) {
                    binanceRepository.getKlines(symbol, DEFAULT_INTERVAL, DEFAULT_CANDLE_LIMIT)
                }

                val allCandles = if (historicalCandles.isEmpty()) {
                    listOf(latestCandle)
                } else {
                    val lastHistoricalCandle = historicalCandles.last()
                    when {
                        latestCandle.openTime > lastHistoricalCandle.openTime -> historicalCandles + latestCandle
                        latestCandle.openTime == lastHistoricalCandle.openTime -> {
                            Timber.d("$symbol: Latest candle from stream has the same openTime as the last historical candle. Replacing last historical with latest.")
                            historicalCandles.dropLast(1) + latestCandle
                        }
                        else -> { // latestCandle.openTime < lastHistoricalCandle.openTime
                            Timber.w("$symbol: Latest candle from stream (openTime: ${latestCandle.openTime}) is older than the last historical candle (openTime: ${lastHistoricalCandle.openTime}). Discarding latest candle.")
                            historicalCandles
                        }
                    }
                }
                
                if (allCandles.isEmpty()) {
                    Timber.w("$symbol: No candle data available for $DEFAULT_INTERVAL after processing stream update.")
                    TradingSignal.NEUTRAL
                } else {
                    val indicators = withContext(Dispatchers.Default) {
                        calculateIndicatorsUseCase.execute(allCandles, symbol, DEFAULT_INTERVAL)
                    }
                    
                    when {
                        indicators.isLongSignal() -> TradingSignal.LONG
                        indicators.isShortSignal() -> TradingSignal.SHORT
                        else -> TradingSignal.NEUTRAL
                    }
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
        Log.d("AutoTradeUseCase", "executeTradeSignal: Function entered for $symbol with signal $signal and leverage $leverage")
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
                    BigDecimal.ONE.add(BigDecimal(MAX_RISK_PERCENTAGE / leverage)) // Risk yüzdesi / Kaldıraç ile stop-loss
                )
                takeProfitPrice = currentPrice.multiply(
                    BigDecimal.ONE.subtract(BigDecimal(TAKE_PROFIT_PERCENTAGE / leverage)) // Risk yüzdesi / Kaldıraç ile take-profit
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
                message = "Pozisyon Açılmadı İşlem Hatası: ${e.message}"
            )
        }
    }

    /**
     * Tüm future işlem çiftlerini tarar, belirli pozisyon sinyalinde işlem açar.
     * Her işlem çifti için ayrı bir akış oluşturur ve bu akışları birleştirir.
     * @param targetPosition İşlem açılacak hedef pozisyon (LONG veya SHORT). Null ise tüm sinyallerde işlem açılır.
     * @return İşlem sonuçlarını içeren bir akış.
     */
    fun startAutoTrading(targetPosition: PositionSide?): Flow<TradeResult> = channelFlow {
        Timber.d("startAutoTrading started in UseCase")
        Log.d("AutoTradeUseCase", "startAutoTrading: Function entered.")
        val symbols = try {
            withContext(Dispatchers.IO) {
                binanceRepository.getTradingPairs()
            }
        } catch (e: Exception) {
            Timber.e(e, "İşlem çiftleri alınırken hata oluştu.")
            Log.e("AutoTradeUseCase", "startAutoTrading: Error fetching trading pairs: ${e.message}")
            // Hata durumunda boş bir liste döndürüp akışı sonlandırabiliriz veya hata fırlatabiliriz.
            // Şimdilik boş liste döndürüp loglayalım.
            emptyList<String>()
        }

        Timber.d("startAutoTrading: Fetched ${symbols.size} trading pairs in UseCase")
        Log.d("AutoTradeUseCase", "startAutoTrading: Fetched ${symbols.size} trading pairs.")
        if (symbols.isEmpty()) {
            Log.w("AutoTradeUseCase", "startAutoTrading: No trading pairs found. Aborting.")
        }

        val tradeResultFlows = symbols.map { symbol ->
            binanceRepository.getKlinesStream(symbol, DEFAULT_INTERVAL)
                .catch { e: Throwable ->
                    Timber.e(e, "$symbol klinesStream alınırken hata oluştu: ${e.message}")
                    Log.e("AutoTradeUseCase", "$symbol: Error fetching klines stream: ${e.message}")
                }
                .map { latestCandle ->
                    Log.d("AutoTradeUseCase", "$symbol: Received latestCandle from stream in UseCase. OpenTime: ${latestCandle.openTime}")
                    Timber.d("$symbol: Received new candle update from stream: openTime=${latestCandle.openTime}")
                    val historicalCandles = withContext(Dispatchers.IO) {
                        binanceRepository.getKlines(symbol, DEFAULT_INTERVAL, DEFAULT_CANDLE_LIMIT)
                    }
                    Timber.d("$symbol: Fetched ${historicalCandles.size} historical candles")

                    val allCandles = if (historicalCandles.isEmpty()) {
                        listOf(latestCandle)
                    } else {
                        val lastHistoricalCandle = historicalCandles.last()
                        when {
                            latestCandle.openTime > lastHistoricalCandle.openTime -> historicalCandles + latestCandle
                            latestCandle.openTime == lastHistoricalCandle.openTime -> {
                                Timber.d("$symbol: Latest candle from stream has the same openTime as the last historical candle. Replacing last historical with latest.")
                                historicalCandles.dropLast(1) + latestCandle
                            }
                            else -> { // latestCandle.openTime < lastHistoricalCandle.openTime
                                Timber.w("$symbol: Latest candle from stream (openTime: ${latestCandle.openTime}) is older than the last historical candle (openTime: ${lastHistoricalCandle.openTime}). Discarding latest candle.")
                                historicalCandles
                            }
                        }
                    }
                    Timber.d("$symbol: Processed candle list size: ${allCandles.size}")

                    if (allCandles.isEmpty()) {
                        Timber.w("$symbol: No candle data available for $DEFAULT_INTERVAL after processing stream update. Emitting null.")
                        null // No signal for this candle update, return null
                    } else {
                        val indicators = withContext(Dispatchers.Default) { // Use withContext for CPU-bound work
                            calculateIndicatorsUseCase.execute(allCandles, symbol, DEFAULT_INTERVAL)
                        }
                        Timber.d("$symbol: Indicators calculated.")

                        when {
                            indicators.isLongSignal() -> Pair(symbol, TradingSignal.LONG)
                            indicators.isShortSignal() -> Pair(symbol, TradingSignal.SHORT)
                            else -> null // Nötr sinyal
                        }
                    }
                }
                .filterNotNull() // Sadece sinyal olanları ve null olmayan Pair<Symbol, TradingSignal> olanları filtrele
                .onEach { (symbol, signal) -> Log.d("AutoTradeUseCase", "$symbol: After filterNotNull. Signal: $signal") }
                .onEach { (symbol, signal) -> Timber.d("$symbol: Signal detected: $signal") }
                .filter { (symbol, signal) -> // Hedef pozisyona göre filtrele
                    val filterPassed = when (targetPosition) {
                        PositionSide.LONG -> signal == TradingSignal.LONG
                        PositionSide.SHORT -> signal == TradingSignal.SHORT
                        null -> true // Hedef pozisyon belirlenmemişse tüm sinyalleri işle
                    }
                    Timber.d("$symbol: Filtering signal $signal. Target: $targetPosition. Filter passed: $filterPassed")
                    Log.d("AutoTradeUseCase", "$symbol: After filter. Signal: $signal, Filter passed: $filterPassed")
                    filterPassed
                }
                .flatMapConcat { (symbol, signal) -> // İşlemi gerçekleştir ve TradeResult akışını yayınla
                    Log.d("AutoTradeUseCase", "$symbol: Before flatMapConcat. Signal: $signal")
                    Log.d("AutoTradeUseCase", "$symbol: Inside flatMapConcat, attempting to call executeTradeSignal.")
                    flow {
                        Timber.i("$symbol: Executing trade signal: $signal")
                        // Kaldıraç belirleme mantığı buraya eklenecek (şimdilik sabit 10x)
                        val leverage = 10
                        val tradeResult = executeTradeSignal(symbol, signal, leverage)
                        Timber.i("$symbol: Trade execution result: ${tradeResult.message}")
                        emit(tradeResult) // executeTradeSignal sonucu TradeResult olarak yayınla
                    }.catch { e: Throwable -> // executeTradeSignal içindeki hataları yakala
                        Timber.e(e, "$symbol işlem açılırken hata oluştu: ${e.message}")
                        emit(TradeResult(success = false, message = "$symbol işlem açılırken hata: ${e.message}"))
                    }
                }
                .catch { e: Throwable -> // Her bir sembol akışındaki diğer hataları yakala
                    Timber.e(e, "$symbol işlem çifti için strateji akışında beklenmeyen hata oluştu: ${e.message}")
                    emit(TradeResult(success = false, message = "$symbol için beklenmeyen hata: ${e.message}"))
                }
                .onCompletion { cause -> Log.d("AutoTradeUseCase", "$symbol: Flow completed with cause: $cause") }
                .onEach { tradeResult -> Log.d("AutoTradeUseCase", "$symbol: Emitted TradeResult: ${tradeResult.message}") }
        }

        // Merge all individual symbol flows into a single flow and collect them in this channelFlow
        tradeResultFlows.merge().collect { tradeResult ->
            send(tradeResult) // Send to the outer channelFlow
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

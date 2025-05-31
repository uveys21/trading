package com.uveys.trader.data.repository

import com.uveys.trader.data.api.rest.BinanceApiService
import com.uveys.trader.data.api.websocket.BinanceWebSocketManager
import com.uveys.trader.data.dto.OrderDto
import com.uveys.trader.data.mapper.BinanceMapper
import com.uveys.trader.domain.entity.*
import com.uveys.trader.domain.repository.BinanceRepository
import com.uveys.trader.util.security.SecurePreferencesManager
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import timber.log.Timber
import java.math.BigDecimal
import java.util.Date
import javax.inject.Inject
import javax.inject.Singleton

/**
 * BinanceRepository arayüzünün uygulaması
 */
@Singleton
class BinanceRepositoryImpl @Inject constructor(
    private val apiService: BinanceApiService,
    private val webSocketManager: BinanceWebSocketManager,
    private val mapper: BinanceMapper,
    private val securePreferencesManager: SecurePreferencesManager
) : BinanceRepository {

    override suspend fun getKlines(symbol: String, interval: String, limit: Int): List<Candle> {
        try {
            val response = apiService.getKlines(symbol, interval, limit)
            return response.map { item ->
                Candle(
                    openTime = (item[0] as Double).toLong(),
                    open = BigDecimal(item[1] as String),
                    high = BigDecimal(item[2] as String),
                    low = BigDecimal(item[3] as String),
                    close = BigDecimal(item[4] as String),
                    volume = BigDecimal(item[5] as String),
                    closeTime = (item[6] as Double).toLong(),
                    quoteAssetVolume = BigDecimal(item[7] as String),
                    numberOfTrades = (item[8] as Double).toInt(),
                    takerBuyBaseAssetVolume = BigDecimal(item[9] as String),
                    takerBuyQuoteAssetVolume = BigDecimal(item[10] as String)
                )
            }
        } catch (e: Exception) {
            Timber.e(e, "Mum verileri alınırken hata oluştu: $symbol, $interval")
            throw e
        }
    }

    override fun getKlinesStream(symbol: String, interval: String): Flow<Candle> {
        return webSocketManager.subscribeToKlines(symbol, interval)
            .map { mapper.mapToCandle(it) }
    }

    override suspend fun getPrice(symbol: String): BigDecimal {
        try {
            val response = apiService.getPrice(symbol)
            return BigDecimal(response.price)
        } catch (e: Exception) {
            Timber.e(e, "Fiyat bilgisi alınırken hata oluştu: $symbol")
            throw e
        }
    }

    override fun getPriceStream(symbol: String): Flow<BigDecimal> {
        return webSocketManager.subscribeToPriceStream(symbol)
    }

    override suspend fun getAccountBalance(): BigDecimal {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            val response = apiService.getAccount(timestamp, signature)
            
            // USDT bakiyesini bul
            val assets = response["assets"] as List<Map<String, Any>>
            val usdtAsset = assets.find { it["asset"] == "USDT" }
            
            return if (usdtAsset != null) {
                BigDecimal(usdtAsset["availableBalance"] as String)
            } else {
                BigDecimal.ZERO
            }
        } catch (e: Exception) {
            Timber.e(e, "Hesap bakiyesi alınırken hata oluştu")
            throw e
        }
    }

    override suspend fun getOpenPositions(): List<Position> {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            val response = apiService.getPositions(timestamp, signature)
            
            // Sadece açık pozisyonları filtrele (positionAmt != 0)
            return response
                .filter { BigDecimal(it.positionAmt) != BigDecimal.ZERO }
                .map { mapper.mapToPosition(it) }
        } catch (e: Exception) {
            Timber.e(e, "Açık pozisyonlar alınırken hata oluştu")
            throw e
        }
    }

    override suspend fun createMarketOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        quantity: BigDecimal
    ): Order {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            
            val response = apiService.createMarketOrder(
                symbol = symbol,
                side = side.name,
                type = "MARKET",
                positionSide = positionSide.name,
                quantity = quantity.toPlainString(),
                timestamp = timestamp,
                signature = signature
            )
            
            return mapper.mapToOrder(response)
        } catch (e: Exception) {
            Timber.e(e, "Market emri oluşturulurken hata oluştu: $symbol, $side, $positionSide, $quantity")
            throw e
        }
    }

    override suspend fun createLimitOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        price: BigDecimal,
        quantity: BigDecimal
    ): Order {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            
            val response = apiService.createLimitOrder(
                symbol = symbol,
                side = side.name,
                type = "LIMIT",
                positionSide = positionSide.name,
                price = price.toPlainString(),
                quantity = quantity.toPlainString(),
                timeInForce = "GTC", // Good Till Cancel
                timestamp = timestamp,
                signature = signature
            )
            
            return mapper.mapToOrder(response)
        } catch (e: Exception) {
            Timber.e(e, "Limit emri oluşturulurken hata oluştu: $symbol, $side, $positionSide, $price, $quantity")
            throw e
        }
    }

    override suspend fun createStopLossOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        stopPrice: BigDecimal,
        quantity: BigDecimal
    ): Order {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            
            val response = apiService.createStopLossOrder(
                symbol = symbol,
                side = side.name,
                type = "STOP_MARKET",
                positionSide = positionSide.name,
                stopPrice = stopPrice.toPlainString(),
                quantity = quantity.toPlainString(),
                timestamp = timestamp,
                signature = signature
            )
            
            return mapper.mapToOrder(response)
        } catch (e: Exception) {
            Timber.e(e, "Stop-loss emri oluşturulurken hata oluştu: $symbol, $side, $positionSide, $stopPrice, $quantity")
            throw e
        }
    }

    override suspend fun createTakeProfitOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        price: BigDecimal,
        quantity: BigDecimal
    ): Order {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            
            val response = apiService.createTakeProfitOrder(
                symbol = symbol,
                side = side.name,
                type = "TAKE_PROFIT_MARKET",
                positionSide = positionSide.name,
                price = price.toPlainString(),
                quantity = quantity.toPlainString(),
                timestamp = timestamp,
                signature = signature
            )
            
            return mapper.mapToOrder(response)
        } catch (e: Exception) {
            Timber.e(e, "Take-profit emri oluşturulurken hata oluştu: $symbol, $side, $positionSide, $price, $quantity")
            throw e
        }
    }

    override suspend fun setLeverage(symbol: String, leverage: Int): Boolean {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            
            val response = apiService.setLeverage(
                symbol = symbol,
                leverage = leverage,
                timestamp = timestamp,
                signature = signature
            )
            
            return response["leverage"] == leverage
        } catch (e: Exception) {
            Timber.e(e, "Kaldıraç ayarlanırken hata oluştu: $symbol, $leverage")
            throw e
        }
    }

    override suspend fun getOrderHistory(symbol: String, limit: Int): List<Order> {
        try {
            val timestamp = Date().time
            val signature = generateSignature(timestamp)
            
            val response = apiService.getOrderHistory(
                symbol = symbol,
                limit = limit,
                timestamp = timestamp,
                signature = signature
            )
            
            return response.map { mapper.mapToOrder(it) }
        } catch (e: Exception) {
            Timber.e(e, "Emir geçmişi alınırken hata oluştu: $symbol")
            throw e
        }
    }

    override suspend fun ping(): Boolean {
        return try {
            apiService.getPrice("BTCUSDT") // Attempt to get price for BTCUSDT
            true // If the call above does not throw an exception, consider ping successful
        } catch (e: Exception) {
            Timber.e(e, "Ping failed") // Log the exception
            false // If any exception occurs during the API call, consider ping failed
        }
    }

    /**
     * İmza oluşturur
     */
    private fun generateSignature(timestamp: Long): String {
        // Bu kısım BinanceAuthInterceptor tarafından otomatik olarak yapılacak
        // Burada sadece timestamp parametresi ekleniyor
        return "timestamp=$timestamp"
    }
}

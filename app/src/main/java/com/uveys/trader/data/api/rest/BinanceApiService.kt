package com.uveys.trader.data.api.rest

import com.uveys.trader.data.dto.*
import retrofit2.http.*

/**
 * Binance Futures REST API servisi
 */
interface BinanceApiService {

    /**
     * Mum verilerini getirir
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı (örn. "15m", "1h", "4h", "1d")
     * @param limit Getirilecek mum sayısı
     */
    @GET("fapi/v1/klines")
    suspend fun getKlines(
        @Query("symbol") symbol: String,
        @Query("interval") interval: String,
        @Query("limit") limit: Int
    ): List<List<Any>>

    /**
     * Anlık fiyat bilgisini getirir
     * @param symbol Kripto para çifti
     */
    @GET("fapi/v1/ticker/price")
    suspend fun getPrice(
        @Query("symbol") symbol: String
    ): PriceDto

    /**
     * Hesap bilgilerini getirir
     */
    @GET("fapi/v2/account")
    suspend fun getAccount(
        @Query("timestamp") timestamp: Long
    ): Map<String, Any>

    /**
     * Pozisyon bilgilerini getirir
     */
    @GET("fapi/v2/positionRisk")
    suspend fun getPositions(
        @Query("timestamp") timestamp: Long
    ): List<PositionDto>

    /**
     * Market emri oluşturur
     */
    @POST("fapi/v1/order")
    suspend fun createMarketOrder(
        @Query("symbol") symbol: String,
        @Query("side") side: String,
        @Query("type") type: String,
        @Query("positionSide") positionSide: String,
        @Query("quantity") quantity: String,
        @Query("timestamp") timestamp: Long
    ): OrderDto

    /**
     * Limit emri oluşturur
     */
    @POST("fapi/v1/order")
    suspend fun createLimitOrder(
        @Query("symbol") symbol: String,
        @Query("side") side: String,
        @Query("type") type: String,
        @Query("positionSide") positionSide: String,
        @Query("price") price: String,
        @Query("quantity") quantity: String,
        @Query("timeInForce") timeInForce: String,
        @Query("timestamp") timestamp: Long
    ): OrderDto

    /**
     * Stop-loss emri oluşturur
     */
    @POST("fapi/v1/order")
    suspend fun createStopLossOrder(
        @Query("symbol") symbol: String,
        @Query("side") side: String,
        @Query("type") type: String,
        @Query("positionSide") positionSide: String,
        @Query("stopPrice") stopPrice: String,
        @Query("quantity") quantity: String,
        @Query("timestamp") timestamp: Long
    ): OrderDto

    /**
     * Take-profit emri oluşturur
     */
    @POST("fapi/v1/order")
    suspend fun createTakeProfitOrder(
        @Query("symbol") symbol: String,
        @Query("side") side: String,
        @Query("type") type: String,
        @Query("positionSide") positionSide: String,
        @Query("price") price: String,
        @Query("quantity") quantity: String,
        @Query("timestamp") timestamp: Long
    ): OrderDto

    /**
     * Kaldıraç oranını ayarlar
     */
    @POST("fapi/v1/leverage")
    suspend fun setLeverage(
        @Query("symbol") symbol: String,
        @Query("leverage") leverage: Int,
        @Query("timestamp") timestamp: Long
    ): Map<String, Any>

    /**
     * Emir geçmişini getirir
     */
    @GET("fapi/v1/allOrders")
    suspend fun getOrderHistory(
        @Query("symbol") symbol: String,
        @Query("limit") limit: Int,
        @Query("timestamp") timestamp: Long
    ): List<OrderDto>
}

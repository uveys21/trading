package com.uveys.trader.domain.repository

import com.uveys.trader.domain.entity.Candle
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

/**
 * Binance Futures API ile iletişim için repository arayüzü
 */
interface BinanceRepository {
    
    /**
     * Belirli bir sembol ve zaman aralığı için mum verilerini getirir
     * @param symbol Kripto para çifti (örn. "BTCUSDT")
     * @param interval Zaman aralığı (örn. "15m", "1h", "4h", "1d")
     * @param limit Getirilecek mum sayısı
     * @return Mum listesi
     */
    suspend fun getKlines(symbol: String, interval: String, limit: Int): List<Candle>
    
    /**
     * Belirli bir sembol ve zaman aralığı için gerçek zamanlı mum verilerini akış olarak alır
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı
     * @return Mum verisi akışı
     */
    fun getKlinesStream(symbol: String, interval: String): Flow<Candle>
    
    /**
     * Belirli bir sembol için anlık fiyat bilgisini getirir
     * @param symbol Kripto para çifti
     * @return Anlık fiyat
     */
    suspend fun getPrice(symbol: String): BigDecimal
    
    /**
     * Belirli bir sembol için anlık fiyat bilgisini akış olarak alır
     * @param symbol Kripto para çifti
     * @return Fiyat akışı
     */
    fun getPriceStream(symbol: String): Flow<BigDecimal>
    
    /**
     * Hesap bakiyesini getirir
     * @return Bakiye miktarı
     */
    suspend fun getAccountBalance(): BigDecimal
    
    /**
     * Açık pozisyonları getirir
     * @return Açık pozisyonlar
     */
    suspend fun getOpenPositions(): List<com.uveys.trader.domain.entity.Position>
    
    /**
     * Market emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createMarketOrder(
        symbol: String,
        side: com.uveys.trader.domain.entity.OrderSide,
        positionSide: com.uveys.trader.domain.entity.PositionSide,
        quantity: BigDecimal
    ): com.uveys.trader.domain.entity.Order
    
    /**
     * Limit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Fiyat
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createLimitOrder(
        symbol: String,
        side: com.uveys.trader.domain.entity.OrderSide,
        positionSide: com.uveys.trader.domain.entity.PositionSide,
        price: BigDecimal,
        quantity: BigDecimal
    ): com.uveys.trader.domain.entity.Order
    
    /**
     * Stop-loss emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param stopPrice Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createStopLossOrder(
        symbol: String,
        side: com.uveys.trader.domain.entity.OrderSide,
        positionSide: com.uveys.trader.domain.entity.PositionSide,
        stopPrice: BigDecimal,
        quantity: BigDecimal
    ): com.uveys.trader.domain.entity.Order
    
    /**
     * Take-profit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    suspend fun createTakeProfitOrder(
        symbol: String,
        side: com.uveys.trader.domain.entity.OrderSide,
        positionSide: com.uveys.trader.domain.entity.PositionSide,
        price: BigDecimal,
        quantity: BigDecimal
    ): com.uveys.trader.domain.entity.Order
    
    /**
     * Kaldıraç oranını ayarlar
     * @param symbol Kripto para çifti
     * @param leverage Kaldıraç oranı
     * @return İşlem başarılı mı
     */
    suspend fun setLeverage(symbol: String, leverage: Int): Boolean
    
    /**
     * Emir geçmişini getirir
     * @param symbol Kripto para çifti
     * @param limit Getirilecek emir sayısı
     * @return Emir listesi
     */
    suspend fun getOrderHistory(symbol: String, limit: Int): List<com.uveys.trader.domain.entity.Order>
    
    /**
     * API bağlantısının durumunu kontrol eder
     * @return true: Bağlantı aktif, false: Bağlantı yok
     */
    suspend fun ping(): Boolean
    
    /**
     * Tüm ticari çiftleri getirir
     * @return Ticari çiftler listesi
     */
    suspend fun getTradingPairs(): List<String>
}

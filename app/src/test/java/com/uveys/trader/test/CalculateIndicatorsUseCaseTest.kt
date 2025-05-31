package com.uveys.trader.test

import com.uveys.trader.domain.entity.Candle
import com.uveys.trader.domain.entity.TechnicalIndicator
import com.uveys.trader.domain.usecase.CalculateIndicatorsUseCase
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal
import java.util.Date

class CalculateIndicatorsUseCaseTest {

    private lateinit var calculateIndicatorsUseCase: CalculateIndicatorsUseCase
    private lateinit var testCandles: List<Candle>

    @Before
    fun setup() {
        calculateIndicatorsUseCase = CalculateIndicatorsUseCase()
        
        // Test için mum verileri oluştur
        val currentTime = Date().time
        val hourInMillis = 60 * 60 * 1000L
        
        testCandles = List(250) { index ->
            val timeOffset = (250 - index) * hourInMillis
            val basePrice = BigDecimal("30000.00")
            val priceOffset = BigDecimal(index * 10)
            val price = basePrice.add(priceOffset)
            
            Candle(
                openTime = currentTime - timeOffset,
                open = price,
                high = price.multiply(BigDecimal("1.01")),
                low = price.multiply(BigDecimal("0.99")),
                close = price.multiply(BigDecimal("1.005")),
                volume = BigDecimal("100"),
                closeTime = currentTime - timeOffset + hourInMillis - 1,
                quoteAssetVolume = BigDecimal("3000000"),
                numberOfTrades = 1000,
                takerBuyBaseAssetVolume = BigDecimal("50"),
                takerBuyQuoteAssetVolume = BigDecimal("1500000")
            )
        }
    }

    @Test
    fun `test calculate indicators returns valid technical indicator`() {
        // Test verileriyle göstergeleri hesapla
        val result = calculateIndicatorsUseCase.execute(testCandles, "BTCUSDT", "1h")
        
        // Sonuçları doğrula
        assertEquals("BTCUSDT", result.symbol)
        assertEquals("1h", result.interval)
        
        // Tüm gösterge değerlerinin var olduğunu kontrol et
        assertTrue(result.indicators.containsKey(TechnicalIndicator.EMA_50))
        assertTrue(result.indicators.containsKey(TechnicalIndicator.EMA_200))
        assertTrue(result.indicators.containsKey(TechnicalIndicator.RSI))
        assertTrue(result.indicators.containsKey(TechnicalIndicator.MACD_LINE))
        assertTrue(result.indicators.containsKey(TechnicalIndicator.MACD_SIGNAL))
        assertTrue(result.indicators.containsKey(TechnicalIndicator.MACD_HISTOGRAM))
        
        // Değerlerin sıfırdan büyük olduğunu kontrol et
        assertTrue(result.indicators[TechnicalIndicator.EMA_50]!! > BigDecimal.ZERO)
        assertTrue(result.indicators[TechnicalIndicator.EMA_200]!! > BigDecimal.ZERO)
    }
    
    @Test
    fun `test long signal detection`() {
        // Uzun pozisyon sinyali için test verileri oluştur
        val indicators = mapOf(
            TechnicalIndicator.EMA_50 to BigDecimal("31000"),
            TechnicalIndicator.EMA_200 to BigDecimal("30000"),
            TechnicalIndicator.RSI to BigDecimal("60"),
            TechnicalIndicator.MACD_LINE to BigDecimal("100"),
            TechnicalIndicator.MACD_SIGNAL to BigDecimal("50"),
            TechnicalIndicator.MACD_HISTOGRAM to BigDecimal("50")
        )
        
        val technicalIndicator = TechnicalIndicator(
            symbol = "BTCUSDT",
            interval = "1h",
            timestamp = Date().time,
            indicators = indicators
        )
        
        // Long sinyali doğrula
        assertTrue(technicalIndicator.isLongSignal())
    }
    
    @Test
    fun `test short signal detection`() {
        // Kısa pozisyon sinyali için test verileri oluştur
        val indicators = mapOf(
            TechnicalIndicator.EMA_50 to BigDecimal("29000"),
            TechnicalIndicator.EMA_200 to BigDecimal("30000"),
            TechnicalIndicator.RSI to BigDecimal("40"),
            TechnicalIndicator.MACD_LINE to BigDecimal("50"),
            TechnicalIndicator.MACD_SIGNAL to BigDecimal("100"),
            TechnicalIndicator.MACD_HISTOGRAM to BigDecimal("-50")
        )
        
        val technicalIndicator = TechnicalIndicator(
            symbol = "BTCUSDT",
            interval = "1h",
            timestamp = Date().time,
            indicators = indicators
        )
        
        // Short sinyali doğrula
        assertTrue(technicalIndicator.isShortSignal())
    }
}

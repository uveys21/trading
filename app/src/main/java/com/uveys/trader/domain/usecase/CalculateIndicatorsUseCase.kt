package com.uveys.trader.domain.usecase

import com.uveys.trader.domain.entity.Candle
import com.uveys.trader.domain.entity.TechnicalIndicator
import org.ta4j.core.BarSeries
import org.ta4j.core.BaseBarSeries
import org.ta4j.core.indicators.EMAIndicator
import org.ta4j.core.indicators.MACDIndicator
import org.ta4j.core.indicators.RSIIndicator
import org.ta4j.core.indicators.helpers.ClosePriceIndicator
import org.ta4j.core.num.DecimalNum
import java.math.BigDecimal
import java.time.Duration
import java.time.Instant
import java.time.ZonedDateTime
import java.time.ZoneOffset
import java.time.ZoneId
import javax.inject.Inject

/**
 * Teknik göstergeleri hesaplayan use case
 */
class CalculateIndicatorsUseCase @Inject constructor() {

    /**
     * Verilen mum verileri için teknik göstergeleri hesaplar
     * @param candles Mum verileri listesi
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı
     * @return Teknik gösterge sonuçları
     */
    fun execute(candles: List<Candle>, symbol: String, interval: String): TechnicalIndicator {
        // Ta4j kütüphanesi için BarSeries oluştur
        val series = createBarSeries(candles)
        
        // Fiyat göstergesi
        val closePrice = ClosePriceIndicator(series)
        
        // EMA göstergeleri
        val ema50 = EMAIndicator(closePrice, 50)
        val ema200 = EMAIndicator(closePrice, 200)
        
        // RSI göstergesi
        val rsi = RSIIndicator(closePrice, 14)
        
        // MACD göstergesi
        val macd = MACDIndicator(closePrice, 12, 26)
        val macdSignal = EMAIndicator(macd, 9)
        
        // Son değerleri al
        val lastIndex = series.endIndex
        val ema50Value = ema50.getValue(lastIndex).doubleValue()
        val ema200Value = ema200.getValue(lastIndex).doubleValue()
        val rsiValue = rsi.getValue(lastIndex).doubleValue()
        val macdValue = macd.getValue(lastIndex).doubleValue()
        val macdSignalValue = macdSignal.getValue(lastIndex).doubleValue()
        val macdHistogram = macdValue - macdSignalValue
        
        // Gösterge değerlerini map olarak oluştur
        val indicators = mapOf(
            TechnicalIndicator.EMA_50 to BigDecimal(ema50Value),
            TechnicalIndicator.EMA_200 to BigDecimal(ema200Value),
            TechnicalIndicator.RSI to BigDecimal(rsiValue),
            TechnicalIndicator.MACD_LINE to BigDecimal(macdValue),
            TechnicalIndicator.MACD_SIGNAL to BigDecimal(macdSignalValue),
            TechnicalIndicator.MACD_HISTOGRAM to BigDecimal(macdHistogram)
        )
        
        return TechnicalIndicator(
            symbol = symbol,
            interval = interval,
            timestamp = System.currentTimeMillis(),
            indicators = indicators
        )
    }
    
    /**
     * Mum verilerinden Ta4j BarSeries oluşturur
     */
    private fun createBarSeries(candles: List<Candle>): BarSeries {
        val series = BaseBarSeries()

        val sortedAndUniqueCandles = candles.sortedBy { it.closeTime }.distinctBy { it.closeTime }

        for (candle in sortedAndUniqueCandles) {
            val barEndTime = Instant.ofEpochMilli(candle.closeTime)
                .atZone(ZoneOffset.UTC)



            val lastBarEndTime: ZonedDateTime? = if (!series.isEmpty) {
                series.getBar(series.endIndex).endTime
            } else {
                null
            }
            timber.log.Timber.d("Attempting to add bar with openTime: ${Instant.ofEpochMilli(candle.openTime).atZone(ZoneOffset.UTC)}, closeTime: $barEndTime. Last bar end time in series: $lastBarEndTime")

            series.addBar(
                barEndTime,
                DecimalNum.valueOf(candle.open), 
                DecimalNum.valueOf(candle.high),
                DecimalNum.valueOf(candle.low),
                DecimalNum.valueOf(candle.close),
                DecimalNum.valueOf(candle.volume)
            )
        }

        return series
    }
}

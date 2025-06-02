package com.uveys.trader.domain.entity

import java.math.BigDecimal

/**
 * Teknik gösterge sonuçları için veri modeli
 */
data class TechnicalIndicator(
    val symbol: String,
    val interval: String,
    val timestamp: Long,
    val indicators: Map<String, BigDecimal>
) {
    companion object {
        const val EMA_50 = "ema50"
        const val EMA_200 = "ema200"
        const val RSI = "rsi"
        const val MACD_LINE = "macdLine"
        const val MACD_SIGNAL = "macdSignal"
        const val MACD_HISTOGRAM = "macdHistogram"
    }

    fun isLongSignal(): Boolean {
        val ema50 = indicators[EMA_50] ?: return false
        val ema200 = indicators[EMA_200] ?: return false
        val rsi = indicators[RSI] ?: return false
        val macdLine = indicators[MACD_LINE] ?: return false
        val macdSignal = indicators[MACD_SIGNAL] ?: return false
        val macdHistogram = indicators[MACD_HISTOGRAM] ?: return false

        // Log indicator values for debugging
        println("EMA 50: $ema50, EMA 200: $ema200, RSI: $rsi, MACD Line: $macdLine, MACD Signal: $macdSignal, MACD Histogram: $macdHistogram")

        // Adjusted conditions for more sensitivity
        return (ema50 > ema200 && rsi > BigDecimal("30")) ||
                (macdHistogram > BigDecimal.ZERO && macdLine > macdSignal)
    }

    fun isShortSignal(): Boolean {
        val ema50 = indicators[EMA_50] ?: return false
        val ema200 = indicators[EMA_200] ?: return false
        val rsi = indicators[RSI] ?: return false
        val macdLine = indicators[MACD_LINE] ?: return false
        val macdSignal = indicators[MACD_SIGNAL] ?: return false
        val macdHistogram = indicators[MACD_HISTOGRAM] ?: return false

        return ema50 < ema200 ||
                rsi < BigDecimal("60") ||
                macdHistogram < BigDecimal.ZERO ||
                (macdLine < macdSignal)
    }
}

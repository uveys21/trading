package com.uveys.trader.domain.entity

import java.math.BigDecimal
import java.util.Date

/**
 * Mum (Candlestick) veri modeli
 * Teknik analiz için kullanılacak temel veri yapısı
 */
data class Candle(
    val openTime: Long,
    val open: BigDecimal,
    val high: BigDecimal,
    val low: BigDecimal,
    val close: BigDecimal,
    val volume: BigDecimal,
    val closeTime: Long,
    val quoteAssetVolume: BigDecimal,
    val numberOfTrades: Int,
    val takerBuyBaseAssetVolume: BigDecimal,
    val takerBuyQuoteAssetVolume: BigDecimal
) {
    val date: Date
        get() = Date(openTime)
        
    val isGreen: Boolean
        get() = close >= open
}

package com.uveys.trader.domain.entity

import java.math.BigDecimal
import java.math.RoundingMode

/**
 * İşlem pozisyonu veri modeli
 */
data class Position(
    val symbol: String,
    val positionSide: PositionSide,
    val entryPrice: BigDecimal,
    val markPrice: BigDecimal,
    val leverage: Int,
    val unrealizedProfit: BigDecimal,
    val marginType: String,
    val isolatedMargin: BigDecimal,
    val positionAmt: BigDecimal,
    val updateTime: Long
) {
    val isInProfit: Boolean
        get() = unrealizedProfit > BigDecimal.ZERO

    val profitPercentage: BigDecimal
        get() {
            if (entryPrice.compareTo(BigDecimal.ZERO) == 0) return BigDecimal.ZERO

            val difference = when (positionSide) {
                PositionSide.LONG -> markPrice - entryPrice
                PositionSide.SHORT -> entryPrice - markPrice
            }

            return difference
                .divide(entryPrice, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal(100))
                .multiply(BigDecimal(leverage))
        }
}

enum class PositionSide {
    LONG,
    SHORT;

    val displayName: String
        get() = when (this) {
            LONG -> "Long"
            SHORT -> "Short"
        }
}


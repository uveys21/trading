package com.uveys.trader.domain.entity

import java.math.BigDecimal

/**
 * Emir veri modeli
 */
data class Order(
    val orderId: Long,
    val symbol: String,
    val status: OrderStatus,
    val clientOrderId: String,
    val price: BigDecimal,
    val avgPrice: BigDecimal,
    val origQty: BigDecimal,
    val executedQty: BigDecimal,
    val type: OrderType,
    val side: OrderSide,
    val stopPrice: BigDecimal,
    val time: Long,
    val updateTime: Long,
    val positionSide: PositionSide,
    val closePosition: Boolean,
    val reduceOnly: Boolean,
    val workingType: String,
    val priceProtect: Boolean
)

enum class OrderStatus {
    NEW, PARTIALLY_FILLED, FILLED, CANCELED, REJECTED, EXPIRED
}

enum class OrderType {
    LIMIT, MARKET, STOP, STOP_MARKET, TAKE_PROFIT, TAKE_PROFIT_MARKET
}

enum class OrderSide {
    BUY, SELL
}

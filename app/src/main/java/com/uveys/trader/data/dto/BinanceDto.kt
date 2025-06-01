package com.uveys.trader.data.dto

import com.google.gson.annotations.SerializedName
import java.math.BigDecimal

/**
 * Binance API'den gelen mum verisi DTO'su
 */
data class CandleDto(
    @SerializedName("t") val openTime: Long,
    @SerializedName("o") val open: String?,
    @SerializedName("h") val high: String?,
    @SerializedName("l") val low: String?,
    @SerializedName("c") val close: String?,
    @SerializedName("v") val volume: String?,
    @SerializedName("T") val closeTime: Long,
    @SerializedName("q") val quoteAssetVolume: String?,
    @SerializedName("n") val numberOfTrades: Int,
    @SerializedName("V") val takerBuyBaseAssetVolume: String?,
    @SerializedName("Q") val takerBuyQuoteAssetVolume: String?
)

/**
 * Binance API'den gelen pozisyon verisi DTO'su
 */
data class PositionDto(
    @SerializedName("symbol") val symbol: String,
    @SerializedName("positionSide") val positionSide: String,
    @SerializedName("entryPrice") val entryPrice: String?,
    @SerializedName("markPrice") val markPrice: String?,
    @SerializedName("leverage") val leverage: Int,
    @SerializedName("unrealizedProfit") val unrealizedProfit: String?,
    @SerializedName("marginType") val marginType: String,
    @SerializedName("isolatedMargin") val isolatedMargin: String?,
    @SerializedName("positionAmt") val positionAmt: String?,
    @SerializedName("updateTime") val updateTime: Long
)

/**
 * Binance API'den gelen emir verisi DTO'su
 */
data class OrderDto(
    @SerializedName("orderId") val orderId: Long,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("status") val status: String,
    @SerializedName("clientOrderId") val clientOrderId: String,
    @SerializedName("price") val price: String?,
    @SerializedName("avgPrice") val avgPrice: String?,
    @SerializedName("origQty") val origQty: String?,
    @SerializedName("executedQty") val executedQty: String?,
    @SerializedName("type") val type: String,
    @SerializedName("side") val side: String,
    @SerializedName("stopPrice") val stopPrice: String?,
    @SerializedName("time") val time: Long,
    @SerializedName("updateTime") val updateTime: Long,
    @SerializedName("positionSide") val positionSide: String,
    @SerializedName("closePosition") val closePosition: Boolean,
    @SerializedName("reduceOnly") val reduceOnly: Boolean,
    @SerializedName("workingType") val workingType: String,
    @SerializedName("priceProtect") val priceProtect: Boolean
)

/**
 * Binance API'den gelen fiyat verisi DTO'su
 */
data class PriceDto(
    @SerializedName("symbol") val symbol: String,
    @SerializedName("price") val price: String?
)

/**
 * Binance API'den gelen hesap bakiyesi DTO'su
 */
data class AccountBalanceDto(
    @SerializedName("asset") val asset: String,
    @SerializedName("balance") val balance: String?,
    @SerializedName("crossWalletBalance") val crossWalletBalance: String?,
    @SerializedName("availableBalance") val availableBalance: String?
)

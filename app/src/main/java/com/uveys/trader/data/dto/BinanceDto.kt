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

// Yeni eklenen DTO'lar

data class ExchangeInfoResponse(
    val timezone: String,
    val serverTime: Long,
    val rateLimits: List<RateLimit>,
    val exchangeFilters: List<Any>, // Filtre detaylarına ihtiyacımız olmayabilir, Any kullanabiliriz
    val symbols: List<Symbol>
)

data class RateLimit(
    val rateLimitType: String,
    val interval: String,
    val intervalNum: Int,
    val limit: Int
)

data class Symbol(
    val symbol: String,
    val status: String, // TRADING, HALT, BREAK gibi durumlar
    val baseAsset: String,
    val baseAssetPrecision: Int,
    val quoteAsset: String,
    val quotePrecision: Int,
    val quoteAssetPrecision: Int,
    val baseCommissionPrecision: Int,
    val quoteCommissionPrecision: Int,
    val orderTypes: List<String>,
    val icebergAllowed: Boolean,
    val ocoAllowed: Boolean,
    val otoAllowed: Boolean,
    val quoteOrderQtyMarketAllowed: Boolean,
    val allowTrailingStop: Boolean,
    val cancelReplaceAllowed: Boolean,
    val allowAmend: Boolean,
    val isSpotTradingAllowed: Boolean,
    val isMarginTradingAllowed: Boolean,
    val filters: List<SymbolFilter>,
    val permissions: List<String>,
    val permissionSets: List<String>,
    val defaultSelfTradePreventionMode: String,
    val allowedSelfTradePreventionModes: List<String>
)

data class SymbolFilter(
    val filterType: String,
    // Farklı filtre türlerine göre farklı alanlar olabilir.
    // İhtiyacımız oldukça buraya ekleyebiliriz.
    @SerializedName("minPrice") val minPrice: String?,
    @SerializedName("maxPrice") val maxPrice: String?,
    @SerializedName("tickSize") val tickSize: String?,
    @SerializedName("minQty") val minQty: String?,
    @SerializedName("maxQty") val maxQty: String?,
    @SerializedName("stepSize") val stepSize: String?,
    @SerializedName("limit") val limit: Int?, // MAX_NUM_ORDERS için limit
    @SerializedName("minNotional") val minNotional: String?, // MIN_NOTIONAL için
    @SerializedName("applyToMarket") val applyToMarket: Boolean? // MIN_NOTIONAL için
)

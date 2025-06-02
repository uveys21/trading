package com.uveys.trader.data.mapper

import com.uveys.trader.data.dto.*
import com.uveys.trader.domain.entity.*
import java.math.BigDecimal

/**
 * DTO'ları domain modellerine dönüştüren mapper sınıfı
 */
class BinanceMapper {

    fun mapToCandle(dto: CandleDto): Candle {
        return Candle(
            openTime = dto.openTime,
            open = BigDecimal(dto.open ?: "0"),
            high = BigDecimal(dto.high ?: "0"),
            low = BigDecimal(dto.low ?: "0"),
            close = BigDecimal(dto.close ?: "0"),
            volume = BigDecimal(dto.volume ?: "0"),
            closeTime = dto.closeTime,
            quoteAssetVolume = BigDecimal(dto.quoteAssetVolume ?: "0"),
            numberOfTrades = dto.numberOfTrades,
            takerBuyBaseAssetVolume = BigDecimal(dto.takerBuyBaseAssetVolume ?: "0"),
            takerBuyQuoteAssetVolume = BigDecimal(dto.takerBuyQuoteAssetVolume ?: "0")
        )
    }

    fun mapToPosition(dto: PositionDto): Position {
        return Position(
            symbol = dto.symbol,
            positionSide = when (dto.positionSide) {
                "LONG" -> PositionSide.LONG
                "SHORT" -> PositionSide.SHORT
                else -> PositionSide.LONG // Varsayılan değer
            },
            entryPrice = BigDecimal(dto.entryPrice ?: "0"),
            markPrice = BigDecimal(dto.markPrice ?: "0"),
            leverage = dto.leverage,
            unrealizedProfit = BigDecimal(dto.unrealizedProfit ?: "0"),
            marginType = dto.marginType,
            isolatedMargin = BigDecimal(dto.isolatedMargin ?: "0"),
            positionAmt = BigDecimal(dto.positionAmt ?: "0"),
            updateTime = dto.updateTime
        )
    }

    fun mapToOrder(dto: OrderDto): Order {
        return Order(
            orderId = dto.orderId,
            symbol = dto.symbol,
            status = when (dto.status) {
                "NEW" -> OrderStatus.NEW
                "PARTIALLY_FILLED" -> OrderStatus.PARTIALLY_FILLED
                "FILLED" -> OrderStatus.FILLED
                "CANCELED" -> OrderStatus.CANCELED
                "REJECTED" -> OrderStatus.REJECTED
                "EXPIRED" -> OrderStatus.EXPIRED
                else -> OrderStatus.NEW
            },
            clientOrderId = dto.clientOrderId,
            price = BigDecimal(dto.price ?: "0"),
            avgPrice = BigDecimal(dto.avgPrice ?: "0"),
            origQty = BigDecimal(dto.origQty ?: "0"),
            executedQty = BigDecimal(dto.executedQty ?: "0"),
            type = when (dto.type) {
                "LIMIT" -> OrderType.LIMIT
                "MARKET" -> OrderType.MARKET
                "STOP" -> OrderType.STOP
                "STOP_MARKET" -> OrderType.STOP_MARKET
                "TAKE_PROFIT" -> OrderType.TAKE_PROFIT
                "TAKE_PROFIT_MARKET" -> OrderType.TAKE_PROFIT_MARKET
                else -> OrderType.MARKET
            },
            side = when (dto.side) {
                "BUY" -> OrderSide.BUY
                "SELL" -> OrderSide.SELL
                else -> OrderSide.BUY
            },
            stopPrice = BigDecimal(dto.stopPrice ?: "0"),
            time = dto.time,
            updateTime = dto.updateTime,
            positionSide = when (dto.positionSide) {
                "LONG" -> PositionSide.LONG
                "SHORT" -> PositionSide.SHORT
                else -> PositionSide.LONG
            },
            closePosition = dto.closePosition,
            reduceOnly = dto.reduceOnly,
            workingType = dto.workingType,
            priceProtect = dto.priceProtect
        )
    }
}

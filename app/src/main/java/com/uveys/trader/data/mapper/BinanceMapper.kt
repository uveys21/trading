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
            open = BigDecimal(dto.open),
            high = BigDecimal(dto.high),
            low = BigDecimal(dto.low),
            close = BigDecimal(dto.close),
            volume = BigDecimal(dto.volume),
            closeTime = dto.closeTime,
            quoteAssetVolume = BigDecimal(dto.quoteAssetVolume),
            numberOfTrades = dto.numberOfTrades,
            takerBuyBaseAssetVolume = BigDecimal(dto.takerBuyBaseAssetVolume),
            takerBuyQuoteAssetVolume = BigDecimal(dto.takerBuyQuoteAssetVolume)
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
            entryPrice = BigDecimal(dto.entryPrice),
            markPrice = BigDecimal(dto.markPrice),
            leverage = dto.leverage,
            unrealizedProfit = BigDecimal(dto.unrealizedProfit),
            marginType = dto.marginType,
            isolatedMargin = BigDecimal(dto.isolatedMargin),
            positionAmt = BigDecimal(dto.positionAmt),
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
            price = BigDecimal(dto.price),
            avgPrice = BigDecimal(dto.avgPrice),
            origQty = BigDecimal(dto.origQty),
            executedQty = BigDecimal(dto.executedQty),
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
            stopPrice = BigDecimal(dto.stopPrice),
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

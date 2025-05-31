package com.uveys.trader.test

import com.uveys.trader.data.dto.CandleDto
import com.uveys.trader.data.dto.OrderDto
import com.uveys.trader.data.dto.PositionDto
import com.uveys.trader.data.mapper.BinanceMapper
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.OrderStatus
import com.uveys.trader.domain.entity.OrderType
import com.uveys.trader.domain.entity.PositionSide
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import java.math.BigDecimal

class BinanceMapperTest {

    private lateinit var mapper: BinanceMapper

    @Before
    fun setup() {
        mapper = BinanceMapper()
    }

    @Test
    fun `test mapToCandle correctly maps CandleDto to Candle`() {
        // Arrange
        val candleDto = CandleDto(
            openTime = 1625097600000,
            open = "35000.00",
            high = "36000.00",
            low = "34500.00",
            close = "35500.00",
            volume = "100.5",
            closeTime = 1625097900000,
            quoteAssetVolume = "3517500.00",
            numberOfTrades = 1250,
            takerBuyBaseAssetVolume = "60.3",
            takerBuyQuoteAssetVolume = "2110500.00"
        )

        // Act
        val result = mapper.mapToCandle(candleDto)

        // Assert
        assertEquals(1625097600000, result.openTime)
        assertEquals(BigDecimal("35000.00"), result.open)
        assertEquals(BigDecimal("36000.00"), result.high)
        assertEquals(BigDecimal("34500.00"), result.low)
        assertEquals(BigDecimal("35500.00"), result.close)
        assertEquals(BigDecimal("100.5"), result.volume)
        assertEquals(1625097900000, result.closeTime)
        assertEquals(BigDecimal("3517500.00"), result.quoteAssetVolume)
        assertEquals(1250, result.numberOfTrades)
        assertEquals(BigDecimal("60.3"), result.takerBuyBaseAssetVolume)
        assertEquals(BigDecimal("2110500.00"), result.takerBuyQuoteAssetVolume)
    }

    @Test
    fun `test mapToPosition correctly maps PositionDto to Position`() {
        // Arrange
        val positionDto = PositionDto(
            symbol = "BTCUSDT",
            positionSide = "LONG",
            entryPrice = "35000.00",
            markPrice = "35500.00",
            leverage = 10,
            unrealizedProfit = "500.00",
            marginType = "ISOLATED",
            isolatedMargin = "350.00",
            positionAmt = "0.1",
            updateTime = 1625097600000
        )

        // Act
        val result = mapper.mapToPosition(positionDto)

        // Assert
        assertEquals("BTCUSDT", result.symbol)
        assertEquals(PositionSide.LONG, result.positionSide)
        assertEquals(BigDecimal("35000.00"), result.entryPrice)
        assertEquals(BigDecimal("35500.00"), result.markPrice)
        assertEquals(10, result.leverage)
        assertEquals(BigDecimal("500.00"), result.unrealizedProfit)
        assertEquals("ISOLATED", result.marginType)
        assertEquals(BigDecimal("350.00"), result.isolatedMargin)
        assertEquals(BigDecimal("0.1"), result.positionAmt)
        assertEquals(1625097600000, result.updateTime)
    }

    @Test
    fun `test mapToOrder correctly maps OrderDto to Order`() {
        // Arrange
        val orderDto = OrderDto(
            orderId = 12345L,
            symbol = "BTCUSDT",
            status = "FILLED",
            clientOrderId = "test123",
            price = "35000.00",
            avgPrice = "35100.00",
            origQty = "0.1",
            executedQty = "0.1",
            type = "MARKET",
            side = "BUY",
            stopPrice = "0.00",
            time = 1625097600000,
            updateTime = 1625097600000,
            positionSide = "LONG",
            closePosition = false,
            reduceOnly = false,
            workingType = "CONTRACT_PRICE",
            priceProtect = false
        )

        // Act
        val result = mapper.mapToOrder(orderDto)

        // Assert
        assertEquals(12345L, result.orderId)
        assertEquals("BTCUSDT", result.symbol)
        assertEquals(OrderStatus.FILLED, result.status)
        assertEquals("test123", result.clientOrderId)
        assertEquals(BigDecimal("35000.00"), result.price)
        assertEquals(BigDecimal("35100.00"), result.avgPrice)
        assertEquals(BigDecimal("0.1"), result.origQty)
        assertEquals(BigDecimal("0.1"), result.executedQty)
        assertEquals(OrderType.MARKET, result.type)
        assertEquals(OrderSide.BUY, result.side)
        assertEquals(BigDecimal("0.00"), result.stopPrice)
        assertEquals(1625097600000, result.time)
        assertEquals(1625097600000, result.updateTime)
        assertEquals(PositionSide.LONG, result.positionSide)
        assertEquals(false, result.closePosition)
        assertEquals(false, result.reduceOnly)
        assertEquals("CONTRACT_PRICE", result.workingType)
        assertEquals(false, result.priceProtect)
    }

    @Test
    fun `test mapToPosition with unknown positionSide defaults to LONG`() {
        // Arrange
        val positionDto = PositionDto(
            symbol = "BTCUSDT",
            positionSide = "UNKNOWN",
            entryPrice = "35000.00",
            markPrice = "35500.00",
            leverage = 10,
            unrealizedProfit = "500.00",
            marginType = "ISOLATED",
            isolatedMargin = "350.00",
            positionAmt = "0.1",
            updateTime = 1625097600000
        )

        // Act
        val result = mapper.mapToPosition(positionDto)

        // Assert
        assertEquals(PositionSide.LONG, result.positionSide)
    }

    @Test
    fun `test mapToOrder with unknown status defaults to NEW`() {
        // Arrange
        val orderDto = OrderDto(
            orderId = 12345L,
            symbol = "BTCUSDT",
            status = "UNKNOWN",
            clientOrderId = "test123",
            price = "35000.00",
            avgPrice = "35100.00",
            origQty = "0.1",
            executedQty = "0.1",
            type = "MARKET",
            side = "BUY",
            stopPrice = "0.00",
            time = 1625097600000,
            updateTime = 1625097600000,
            positionSide = "LONG",
            closePosition = false,
            reduceOnly = false,
            workingType = "CONTRACT_PRICE",
            priceProtect = false
        )

        // Act
        val result = mapper.mapToOrder(orderDto)

        // Assert
        assertEquals(OrderStatus.NEW, result.status)
    }

    @Test
    fun `test mapToOrder with unknown type defaults to MARKET`() {
        // Arrange
        val orderDto = OrderDto(
            orderId = 12345L,
            symbol = "BTCUSDT",
            status = "FILLED",
            clientOrderId = "test123",
            price = "35000.00",
            avgPrice = "35100.00",
            origQty = "0.1",
            executedQty = "0.1",
            type = "UNKNOWN",
            side = "BUY",
            stopPrice = "0.00",
            time = 1625097600000,
            updateTime = 1625097600000,
            positionSide = "LONG",
            closePosition = false,
            reduceOnly = false,
            workingType = "CONTRACT_PRICE",
            priceProtect = false
        )

        // Act
        val result = mapper.mapToOrder(orderDto)

        // Assert
        assertEquals(OrderType.MARKET, result.type)
    }

    @Test
    fun `test mapToOrder with unknown side defaults to BUY`() {
        // Arrange
        val orderDto = OrderDto(
            orderId = 12345L,
            symbol = "BTCUSDT",
            status = "FILLED",
            clientOrderId = "test123",
            price = "35000.00",
            avgPrice = "35100.00",
            origQty = "0.1",
            executedQty = "0.1",
            type = "MARKET",
            side = "UNKNOWN",
            stopPrice = "0.00",
            time = 1625097600000,
            updateTime = 1625097600000,
            positionSide = "LONG",
            closePosition = false,
            reduceOnly = false,
            workingType = "CONTRACT_PRICE",
            priceProtect = false
        )

        // Act
        val result = mapper.mapToOrder(orderDto)

        // Assert
        assertEquals(OrderSide.BUY, result.side)
    }

    @Test
    fun `test mapToOrder with unknown positionSide defaults to LONG`() {
        // Arrange
        val orderDto = OrderDto(
            orderId = 12345L,
            symbol = "BTCUSDT",
            status = "FILLED",
            clientOrderId = "test123",
            price = "35000.00",
            avgPrice = "35100.00",
            origQty = "0.1",
            executedQty = "0.1",
            type = "MARKET",
            side = "BUY",
            stopPrice = "0.00",
            time = 1625097600000,
            updateTime = 1625097600000,
            positionSide = "UNKNOWN",
            closePosition = false,
            reduceOnly = false,
            workingType = "CONTRACT_PRICE",
            priceProtect = false
        )

        // Act
        val result = mapper.mapToOrder(orderDto)

        // Assert
        assertEquals(PositionSide.LONG, result.positionSide)
    }
}
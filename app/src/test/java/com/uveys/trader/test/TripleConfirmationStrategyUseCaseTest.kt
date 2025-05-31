package com.uveys.trader.test

import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.domain.usecase.TradeResult
import com.uveys.trader.domain.usecase.TradingSignal
import com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase
import com.uveys.trader.domain.repository.BinanceRepository
import com.uveys.trader.domain.usecase.CalculateIndicatorsUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.*
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import java.math.BigDecimal

class TripleConfirmationStrategyUseCaseTest {

    private lateinit var strategyUseCase: TripleConfirmationStrategyUseCase
    private lateinit var mockRepository: BinanceRepository
    private lateinit var mockCalculateIndicatorsUseCase: CalculateIndicatorsUseCase

    @Before
    fun setup() {
        mockRepository = mock(BinanceRepository::class.java)
        mockCalculateIndicatorsUseCase = mock(CalculateIndicatorsUseCase::class.java)
        strategyUseCase = TripleConfirmationStrategyUseCase(mockRepository, mockCalculateIndicatorsUseCase)
    }

    @Test
    fun `test executeTradeSignal with LONG signal`() = runBlocking {
        // Mock verileri hazırla
        val symbol = "BTCUSDT"
        val signal = TradingSignal.LONG
        val leverage = 10
        val balance = BigDecimal("1000.00")
        val currentPrice = BigDecimal("30000.00")
        
        // Mock davranışları ayarla
        whenever(mockRepository.setLeverage(symbol, leverage)).thenReturn(true)
        whenever(mockRepository.getAccountBalance()).thenReturn(balance)
        whenever(mockRepository.getPrice(symbol)).thenReturn(currentPrice)
        
        // Market emri için mock
        whenever(mockRepository.createMarketOrder(
            eq(symbol),
            eq(OrderSide.BUY),
            eq(PositionSide.LONG),
            any()
        )).thenReturn(
            com.uveys.trader.domain.entity.Order(
                orderId = 12345L,
                symbol = symbol,
                status = com.uveys.trader.domain.entity.OrderStatus.FILLED,
                clientOrderId = "test123",
                price = BigDecimal.ZERO,
                avgPrice = currentPrice,
                origQty = BigDecimal("0.033"),
                executedQty = BigDecimal("0.033"),
                type = com.uveys.trader.domain.entity.OrderType.MARKET,
                side = OrderSide.BUY,
                stopPrice = BigDecimal.ZERO,
                time = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                positionSide = PositionSide.LONG,
                closePosition = false,
                reduceOnly = false,
                workingType = "CONTRACT_PRICE",
                priceProtect = false
            )
        )
        
        // Stop-loss emri için mock
        whenever(mockRepository.createStopLossOrder(
            eq(symbol),
            eq(OrderSide.SELL),
            eq(PositionSide.LONG),
            any(),
            any()
        )).thenReturn(
            com.uveys.trader.domain.entity.Order(
                orderId = 12346L,
                symbol = symbol,
                status = com.uveys.trader.domain.entity.OrderStatus.NEW,
                clientOrderId = "test124",
                price = BigDecimal.ZERO,
                avgPrice = BigDecimal.ZERO,
                origQty = BigDecimal("0.033"),
                executedQty = BigDecimal.ZERO,
                type = com.uveys.trader.domain.entity.OrderType.STOP_MARKET,
                side = OrderSide.SELL,
                stopPrice = currentPrice.multiply(BigDecimal("0.98")),
                time = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                positionSide = PositionSide.LONG,
                closePosition = false,
                reduceOnly = true,
                workingType = "CONTRACT_PRICE",
                priceProtect = false
            )
        )
        
        // Take-profit emri için mock
        whenever(mockRepository.createTakeProfitOrder(
            eq(symbol),
            eq(OrderSide.SELL),
            eq(PositionSide.LONG),
            any(),
            any()
        )).thenReturn(
            com.uveys.trader.domain.entity.Order(
                orderId = 12347L,
                symbol = symbol,
                status = com.uveys.trader.domain.entity.OrderStatus.NEW,
                clientOrderId = "test125",
                price = currentPrice.multiply(BigDecimal("1.04")),
                avgPrice = BigDecimal.ZERO,
                origQty = BigDecimal("0.033"),
                executedQty = BigDecimal.ZERO,
                type = com.uveys.trader.domain.entity.OrderType.TAKE_PROFIT_MARKET,
                side = OrderSide.SELL,
                stopPrice = BigDecimal.ZERO,
                time = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                positionSide = PositionSide.LONG,
                closePosition = false,
                reduceOnly = true,
                workingType = "CONTRACT_PRICE",
                priceProtect = false
            )
        )
        
        // Stratejiyi çalıştır
        val result = strategyUseCase.executeTradeSignal(symbol, signal, leverage)
        
        // Sonuçları doğrula
        assertTrue(result.success)
        assertEquals(12345L, result.entryOrderId)
        assertEquals(12346L, result.stopLossOrderId)
        assertEquals(12347L, result.takeProfitOrderId)
        
        // Metodların çağrıldığını doğrula
        verify(mockRepository).setLeverage(symbol, leverage)
        verify(mockRepository).getAccountBalance()
        verify(mockRepository).getPrice(symbol)
        verify(mockRepository).createMarketOrder(eq(symbol), eq(OrderSide.BUY), eq(PositionSide.LONG), any())
        verify(mockRepository).createStopLossOrder(eq(symbol), eq(OrderSide.SELL), eq(PositionSide.LONG), any(), any())
        verify(mockRepository).createTakeProfitOrder(eq(symbol), eq(OrderSide.SELL), eq(PositionSide.LONG), any(), any())
    }
    
    @Test
    fun `test executeTradeSignal with SHORT signal`() = runBlocking {
        // Mock verileri hazırla
        val symbol = "BTCUSDT"
        val signal = TradingSignal.SHORT
        val leverage = 10
        val balance = BigDecimal("1000.00")
        val currentPrice = BigDecimal("30000.00")
        
        // Mock davranışları ayarla
        whenever(mockRepository.setLeverage(symbol, leverage)).thenReturn(true)
        whenever(mockRepository.getAccountBalance()).thenReturn(balance)
        whenever(mockRepository.getPrice(symbol)).thenReturn(currentPrice)
        
        // Market emri için mock
        whenever(mockRepository.createMarketOrder(
            eq(symbol),
            eq(OrderSide.SELL),
            eq(PositionSide.SHORT),
            any()
        )).thenReturn(
            com.uveys.trader.domain.entity.Order(
                orderId = 12345L,
                symbol = symbol,
                status = com.uveys.trader.domain.entity.OrderStatus.FILLED,
                clientOrderId = "test123",
                price = BigDecimal.ZERO,
                avgPrice = currentPrice,
                origQty = BigDecimal("0.033"),
                executedQty = BigDecimal("0.033"),
                type = com.uveys.trader.domain.entity.OrderType.MARKET,
                side = OrderSide.SELL,
                stopPrice = BigDecimal.ZERO,
                time = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                positionSide = PositionSide.SHORT,
                closePosition = false,
                reduceOnly = false,
                workingType = "CONTRACT_PRICE",
                priceProtect = false
            )
        )
        
        // Stop-loss emri için mock
        whenever(mockRepository.createStopLossOrder(
            eq(symbol),
            eq(OrderSide.BUY),
            eq(PositionSide.SHORT),
            any(),
            any()
        )).thenReturn(
            com.uveys.trader.domain.entity.Order(
                orderId = 12346L,
                symbol = symbol,
                status = com.uveys.trader.domain.entity.OrderStatus.NEW,
                clientOrderId = "test124",
                price = BigDecimal.ZERO,
                avgPrice = BigDecimal.ZERO,
                origQty = BigDecimal("0.033"),
                executedQty = BigDecimal.ZERO,
                type = com.uveys.trader.domain.entity.OrderType.STOP_MARKET,
                side = OrderSide.BUY,
                stopPrice = currentPrice.multiply(BigDecimal("1.02")),
                time = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                positionSide = PositionSide.SHORT,
                closePosition = false,
                reduceOnly = true,
                workingType = "CONTRACT_PRICE",
                priceProtect = false
            )
        )
        
        // Take-profit emri için mock
        whenever(mockRepository.createTakeProfitOrder(
            eq(symbol),
            eq(OrderSide.BUY),
            eq(PositionSide.SHORT),
            any(),
            any()
        )).thenReturn(
            com.uveys.trader.domain.entity.Order(
                orderId = 12347L,
                symbol = symbol,
                status = com.uveys.trader.domain.entity.OrderStatus.NEW,
                clientOrderId = "test125",
                price = currentPrice.multiply(BigDecimal("0.96")),
                avgPrice = BigDecimal.ZERO,
                origQty = BigDecimal("0.033"),
                executedQty = BigDecimal.ZERO,
                type = com.uveys.trader.domain.entity.OrderType.TAKE_PROFIT_MARKET,
                side = OrderSide.BUY,
                stopPrice = BigDecimal.ZERO,
                time = System.currentTimeMillis(),
                updateTime = System.currentTimeMillis(),
                positionSide = PositionSide.SHORT,
                closePosition = false,
                reduceOnly = true,
                workingType = "CONTRACT_PRICE",
                priceProtect = false
            )
        )
        
        // Stratejiyi çalıştır
        val result = strategyUseCase.executeTradeSignal(symbol, signal, leverage)
        
        // Sonuçları doğrula
        assertTrue(result.success)
        assertEquals(12345L, result.entryOrderId)
        assertEquals(12346L, result.stopLossOrderId)
        assertEquals(12347L, result.takeProfitOrderId)
        
        // Metodların çağrıldığını doğrula
        verify(mockRepository).setLeverage(symbol, leverage)
        verify(mockRepository).getAccountBalance()
        verify(mockRepository).getPrice(symbol)
        verify(mockRepository).createMarketOrder(eq(symbol), eq(OrderSide.SELL), eq(PositionSide.SHORT), any())
        verify(mockRepository).createStopLossOrder(eq(symbol), eq(OrderSide.BUY), eq(PositionSide.SHORT), any(), any())
        verify(mockRepository).createTakeProfitOrder(eq(symbol), eq(OrderSide.BUY), eq(PositionSide.SHORT), any(), any())
    }
    
    @Test
    fun `test executeTradeSignal with NEUTRAL signal`() = runBlocking {
        // Mock verileri hazırla
        val symbol = "BTCUSDT"
        val signal = TradingSignal.NEUTRAL
        val leverage = 10
        
        // Stratejiyi çalıştır
        val result = strategyUseCase.executeTradeSignal(symbol, signal, leverage)
        
        // Sonuçları doğrula
        assertEquals(false, result.success)
        assertEquals("Nötr sinyal, işlem yapılmadı", result.message)
        
        // Hiçbir metodun çağrılmadığını doğrula
        verifyNoInteractions(mockRepository)
    }
}

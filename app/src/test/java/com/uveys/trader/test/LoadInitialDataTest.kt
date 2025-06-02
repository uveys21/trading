package com.uveys.trader.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.uveys.trader.domain.entity.Order
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.OrderStatus
import com.uveys.trader.domain.entity.OrderType
import com.uveys.trader.domain.entity.Position
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.domain.repository.BinanceRepository
import com.uveys.trader.domain.usecase.ManualTradingUseCase
import com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase
import com.uveys.trader.presentation.viewmodel.MainViewModel
import com.uveys.trader.util.security.SecurePreferencesManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import java.math.BigDecimal

@ExperimentalCoroutinesApi
class LoadInitialDataTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    
    private lateinit var viewModel: MainViewModel
    private lateinit var mockManualTradingUseCase: ManualTradingUseCase
    private lateinit var mockStrategyUseCase: TripleConfirmationStrategyUseCase
    private lateinit var mockBinanceRepository: BinanceRepository
    private lateinit var mockSecurePreferencesManager: SecurePreferencesManager

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        
        mockManualTradingUseCase = mock(ManualTradingUseCase::class.java)
        mockStrategyUseCase = mock(TripleConfirmationStrategyUseCase::class.java)
        mockSecurePreferencesManager = mock(SecurePreferencesManager::class.java)
        mockBinanceRepository = mock(BinanceRepository::class.java)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test loadInitialData successfully loads data`() = runTest {
        // Arrange
        val mockBalance = BigDecimal("1000.50")
        val mockPositions = listOf(
            Position(
                symbol = "BTCUSDT",
                positionSide = PositionSide.LONG,
                entryPrice = BigDecimal("30000"),
                markPrice = BigDecimal("31000"),
                leverage = 10,
                unrealizedProfit = BigDecimal("100"),
                marginType = "ISOLATED",
                isolatedMargin = BigDecimal("300"),
                positionAmt = BigDecimal("0.1"),
                updateTime = System.currentTimeMillis()
            )
        )
        val mockOrderHistory = listOf(
            Order(
                orderId = 12345L,
                symbol = "BTCUSDT",
                status = OrderStatus.FILLED,
                clientOrderId = "test123",
                price = BigDecimal.ZERO,
                avgPrice = BigDecimal("30000"),
                origQty = BigDecimal("0.1"),
                executedQty = BigDecimal("0.1"),
                type = OrderType.MARKET,
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

        // Mock repository responses
        whenever(mockBinanceRepository.getAccountBalance()).thenReturn(mockBalance)
        whenever(mockBinanceRepository.getOpenPositions()).thenReturn(mockPositions)
        whenever(mockBinanceRepository.getOrderHistory("BTCUSDT", 20)).thenReturn(mockOrderHistory)
        whenever(mockBinanceRepository.ping()).thenReturn(true) // For the init block connectivity check
        
        // Create viewModel (which calls loadInitialData in init)
        viewModel = MainViewModel(
            mockManualTradingUseCase,
            mockStrategyUseCase,
            mockBinanceRepository,
            mockSecurePreferencesManager
        )
        
        // Advance the dispatcher to complete all coroutines
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        val state = viewModel.uiState.first()
        assertEquals(mockBalance.toPlainString(), state.balance)
        assertEquals(mockPositions, state.positions)
        assertEquals(mockOrderHistory, state.orderHistory)
        assertFalse(state.isLoading)
        
        // Verify repository methods were called
        verify(mockBinanceRepository).getAccountBalance()
        verify(mockBinanceRepository).getOpenPositions()
        verify(mockBinanceRepository).getOrderHistory("BTCUSDT", 20)
    }

    @Test
    fun `test loadInitialData updates UI state correctly`() = runTest {
        // Arrange
        val mockBalance = BigDecimal("500.25")
        val mockPositions = emptyList<Position>()
        val mockOrderHistory = emptyList<Order>()

        // Mock repository responses
        whenever(mockBinanceRepository.getAccountBalance()).thenReturn(mockBalance)
        whenever(mockBinanceRepository.getOpenPositions()).thenReturn(mockPositions)
        whenever(mockBinanceRepository.getOrderHistory(any(), any())).thenReturn(mockOrderHistory)
        whenever(mockBinanceRepository.ping()).thenReturn(true) // For the init block connectivity check
        
        // Create viewModel (which calls loadInitialData in init)
        viewModel = MainViewModel(
            mockManualTradingUseCase,
            mockStrategyUseCase,
            mockBinanceRepository,
            mockSecurePreferencesManager
        )
        
        // Initial state should have isLoading = true
        val initialState = viewModel.uiState.first()
        assertEquals(true, initialState.isLoading)
        
        // Advance the dispatcher to complete all coroutines
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert final state
        val finalState = viewModel.uiState.first()
        assertEquals(mockBalance.toPlainString(), finalState.balance)
        assertEquals(mockPositions, finalState.positions)
        assertEquals(mockOrderHistory, finalState.orderHistory)
        assertEquals(false, finalState.isLoading)
        assertEquals("", finalState.errorMessage)
    }
}
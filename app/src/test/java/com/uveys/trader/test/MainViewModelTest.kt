package com.uveys.trader.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.uveys.trader.domain.entity.Order
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.Position
import com.uveys.trader.domain.entity.PositionSide
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
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import java.math.BigDecimal

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()
    
    private lateinit var viewModel: MainViewModel
    private lateinit var mockManualTradingUseCase: ManualTradingUseCase
    private lateinit var mockStrategyUseCase: TripleConfirmationStrategyUseCase
    private lateinit var mockBinanceRepository: com.uveys.trader.domain.repository.BinanceRepository
    private lateinit var mockSecurePreferencesManager: SecurePreferencesManager

    @Before
    fun setup() = runTest {
        Dispatchers.setMain(testDispatcher)
        
        mockManualTradingUseCase = mock(ManualTradingUseCase::class.java)
        mockStrategyUseCase = mock(TripleConfirmationStrategyUseCase::class.java)
        mockSecurePreferencesManager = mock(SecurePreferencesManager::class.java)
        mockBinanceRepository = mock(com.uveys.trader.domain.repository.BinanceRepository::class.java)

        // Mock suspend functions
        whenever(mockBinanceRepository.getAccountBalance()).thenReturn(java.math.BigDecimal.ZERO)
        whenever(mockBinanceRepository.getOpenPositions()).thenReturn(emptyList())
        whenever(mockBinanceRepository.getOrderHistory(any(), any())).thenReturn(emptyList())
        whenever(mockBinanceRepository.ping()).thenReturn(true) // For the init block connectivity check
        
        viewModel = MainViewModel(
            mockManualTradingUseCase,
            mockStrategyUseCase,
            mockBinanceRepository,
            mockSecurePreferencesManager
        )
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test setLeverage updates state correctly`() = runTest {
        // Arrange
        val newLeverage = 20
        whenever(mockManualTradingUseCase.setLeverage(any(), any())).thenReturn(true)
        
        // Act
        viewModel.setLeverage(newLeverage)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        val state = viewModel.uiState.first()
        assertEquals(newLeverage, state.leverage)
        assertFalse(state.isLoading)
    }

    @Test
    fun `test setRiskPercentage updates state correctly`() = runTest {
        // Arrange
        val newRiskPercentage = 2.5
        
        // Act
        viewModel.setRiskPercentage(newRiskPercentage)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        val state = viewModel.uiState.first()
        assertEquals(newRiskPercentage, state.riskPercentage, 0.001)
    }

    @Test
    fun `test toggleAutoTrade updates state correctly`() = runTest {
        // Arrange
        val initialState = viewModel.uiState.first()
        assertFalse(initialState.isAutoTradeEnabled)
        
        // Act
        viewModel.toggleAutoTrade(true)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        val updatedState = viewModel.uiState.first()
        assertTrue(updatedState.isAutoTradeEnabled)
    }

    @Test
    fun `test logout clears credentials and stops strategy`() = runTest {
        // Act
        viewModel.logout()
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        verify(mockSecurePreferencesManager).clearApiCredentials()
    }

    @Test
    fun `test placeOrder with market order`() = runTest {
        // Arrange
        val symbol = "BTCUSDT"
        val side = OrderSide.BUY
        val positionSide = PositionSide.LONG
        val quantity = BigDecimal("0.1")
        
        val mockOrder = Order(
            orderId = 12345L,
            symbol = symbol,
            status = com.uveys.trader.domain.entity.OrderStatus.FILLED,
            clientOrderId = "test123",
            price = BigDecimal.ZERO,
            avgPrice = BigDecimal("30000"),
            origQty = quantity,
            executedQty = quantity,
            type = com.uveys.trader.domain.entity.OrderType.MARKET,
            side = side,
            stopPrice = BigDecimal.ZERO,
            time = System.currentTimeMillis(),
            updateTime = System.currentTimeMillis(),
            positionSide = positionSide,
            closePosition = false,
            reduceOnly = false,
            workingType = "CONTRACT_PRICE",
            priceProtect = false
        )
        
        whenever(mockManualTradingUseCase.createMarketOrder(symbol, side, positionSide, quantity))
            .thenReturn(mockOrder)
        
        // Act
        viewModel.placeOrder(symbol, side, positionSide, null, quantity)
        testDispatcher.scheduler.advanceUntilIdle()
        
        // Assert
        val state = viewModel.uiState.first()
        assertTrue(state.lastTradeResult.contains("başarıyla"))
        assertFalse(state.isLoading)
    }
}

package com.uveys.trader.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uveys.trader.domain.entity.Order
import com.uveys.trader.domain.entity.OrderSide
import com.uveys.trader.domain.entity.Position
import com.uveys.trader.domain.entity.PositionSide
import com.uveys.trader.domain.usecase.TradingSignal
import com.uveys.trader.domain.usecase.ManualTradingUseCase
import com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase
import com.uveys.trader.domain.repository.BinanceRepository
import com.uveys.trader.util.security.SecurePreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import timber.log.Timber
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Ana ekran UI durumu
 */
data class MainUiState(
    val isLoading: Boolean = true,
    val errorMessage: String = "",
    val balance: String = "0.00",
    val selectedSymbol: String = "BTCUSDT",
    val positions: List<Position> = emptyList(),
    val orderHistory: List<Order> = emptyList(),
    val isStrategyRunning: Boolean = false,
    val isAutoTradeEnabled: Boolean = false,
    val currentSignal: TradingSignal = TradingSignal.NEUTRAL,
    val lastTradeResult: String = "",
    val leverage: Int = 10,
    val riskPercentage: Double = 1.0,
    val connectionStatus: String = "Bağlantı kuruluyor...",
    val connectionLatency: Long = 0,
    val lastSignalTime: Long = 0
)

/**
 * Ana ekran için ViewModel
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val manualTradingUseCase: ManualTradingUseCase,
    private val strategyUseCase: TripleConfirmationStrategyUseCase,
    private val binanceRepository: BinanceRepository,
    private val securePreferencesManager: SecurePreferencesManager
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    private var strategyJob: Job? = null

    init {
        Timber.d("MainViewModel initialized")
        loadInitialData()

        // Bağlantı durumunu düzenli olarak kontrol et
        viewModelScope.launch {
            while (true) {
                try {
                    val startTime = System.currentTimeMillis()
                    val ping = binanceRepository.ping()
                    val latency = System.currentTimeMillis() - startTime

                    _uiState.update {
                        it.copy(
                            connectionStatus = if (ping) "Aktif" else "Bağlantı yok",
                            connectionLatency = latency
                        )
                    }
                } catch (e: Exception) {
                    _uiState.update {
                        it.copy(
                            connectionStatus = "Bağlantı hatası",
                            connectionLatency = 0
                        )
                    }
                }
                delay(5000) // Her 5 saniyede bir kontrol et
            }
        }
    }

    /**
     * Başlangıç verilerini yükler
     */
    private fun loadInitialData() {
        viewModelScope.launch {
            try {
                // Bakiye bilgisini al
                val balance = binanceRepository.getAccountBalance()
                // Açık pozisyonları al
                val positions = binanceRepository.getOpenPositions()
                // Emir geçmişini al
                val orderHistory = binanceRepository.getOrderHistory("BTCUSDT", 20)

                _uiState.update {
                    it.copy(
                        balance = balance.toPlainString(),
                        positions = positions,
                        orderHistory = orderHistory,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                Timber.e(e, "Başlangıç verileri yüklenirken hata oluştu")
                _uiState.update {
                    it.copy(
                        errorMessage = "Veriler yüklenirken hata oluştu: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }

    /**
     * Stratejiyi başlatır
     */
    fun startStrategy(symbol: String) {
        Timber.d("startStrategy function entry point")
        Timber.d("startStrategy called with symbol: $symbol")
        if (strategyJob != null) {
            stopStrategy()
        }

        _uiState.update { it.copy(isStrategyRunning = true, selectedSymbol = symbol) }

        strategyJob = viewModelScope.launch {
            try {
                strategyUseCase.analyzeStrategyStream(symbol)
                    .collect { signal ->
                        Timber.d("Gelen sinyal: $signal")
                        _uiState.update { it.copy(currentSignal = signal) }

                        // Otomatik işlem açma aktifse ve sinyal nötr değilse işlem aç
                        if (_uiState.value.isAutoTradeEnabled && signal != TradingSignal.NEUTRAL) {
                            val result = strategyUseCase.executeTradeSignal(
                                symbol = symbol,
                                signal = signal,
                                leverage = _uiState.value.leverage
                            )

                            _uiState.update {
                                it.copy(
                                    lastTradeResult = result.message,
                                    isLoading = false
                                )
                            }

                            // İşlem sonrası verileri güncelle
                            loadInitialData()
                        }
                    }
            } catch (e: Exception) {
                Timber.e(e, "Strateji çalıştırılırken hata oluştu")
                _uiState.update {
                    it.copy(
                        errorMessage = "Strateji çalıştırılırken hata oluştu: ${e.message}",
                        isStrategyRunning = false,
                        isLoading = false
                    )
                }
            }
        }
    }

    /**
     * Stratejiyi durdurur
     */
    fun stopStrategy() {
        strategyJob?.cancel()
        strategyJob = null
        _uiState.update { it.copy(isStrategyRunning = false, currentSignal = TradingSignal.NEUTRAL) }
    }

    /**
     * Manuel emir verir
     */
    fun placeOrder(
        symbol: String,
        side: OrderSide,
        positionSide: PositionSide,
        price: BigDecimal?,
        quantity: BigDecimal
    ) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true) }

                val order = if (price == null) {
                    // Market emri
                    binanceRepository.createMarketOrder(symbol, side, positionSide, quantity)
                } else {
                    // Limit emri
                    binanceRepository.createLimitOrder(symbol, side, positionSide, price, quantity)
                }

                _uiState.update {
                    it.copy(
                        lastTradeResult = "Emir başarıyla oluşturuldu: ${order.orderId}",
                        isLoading = false
                    )
                }

                // Emir sonrası verileri güncelle
                loadInitialData()

            } catch (e: Exception) {
                Timber.e(e, "Emir oluşturulurken hata oluştu")
                _uiState.update {
                    it.copy(
                        errorMessage = "Emir oluşturulamadı: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }

    /**
     * Kaldıraç oranını ayarlar
     */
    fun setLeverage(leverage: Int) {
        viewModelScope.launch {
            try {
                val success = binanceRepository.setLeverage(uiState.value.selectedSymbol, leverage)
                if (success) {
                    _uiState.update { it.copy(leverage = leverage) }
                } else {
                    _uiState.update {
                        it.copy(
                            errorMessage = "Kaldıraç oranı ayarlanamadı",
                            isLoading = false
                        )
                    }
                }
            } catch (e: Exception) {
                Timber.e(e, "Kaldıraç oranı ayarlanırken hata oluştu")
                _uiState.update {
                    it.copy(
                        errorMessage = "Kaldıraç oranı ayarlanamadı: ${e.message}",
                        isLoading = false
                    )
                }
            }
        }
    }

    /**
     * Risk yüzdesini ayarlar
     */
    fun setRiskPercentage(percentage: Double) {
        _uiState.update { it.copy(riskPercentage = percentage) }
    }

    /**
     * Otomatik işlem açma/kapama durumunu değiştirir
     */
    fun toggleAutoTrade(enabled: Boolean) {
        _uiState.update { it.copy(isAutoTradeEnabled = enabled) }
    }

    /**
     * Çıkış yapar
     */
    fun logout() {
        stopStrategy()
        securePreferencesManager.clearApiCredentials()
    }
}
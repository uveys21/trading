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
    val lastSignalTime: Long = 0,
    val lastTradeDetails: String = "" // <--- EKLENDİ

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

    private fun scheduleMessageClear() {
        viewModelScope.launch {
            delay(5000) // 5 saniye sonra
            _uiState.update { it.copy(lastTradeDetails = "") }
        }
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
                val result = manualTradingUseCase.placeOrder(symbol, side, positionSide, price, quantity)
                _uiState.update {
                    it.copy(
                        lastTradeDetails = "İşlem başarıyla gerçekleştirildi: ${result.orderId}",
                        isLoading = false
                    )
                }
                loadInitialData()
            } catch (e: Exception) {
                val errorMessage = when {
                    e.message?.contains("400") == true -> {
                        when {
                            e.message?.contains("LOT_SIZE") == true ->
                                "Hata: İşlem miktarı geçersiz. Detay: Minimum/maksimum miktar sınırlarına uygun değil"
                            e.message?.contains("PRICE_FILTER") == true ->
                                "Hata: Fiyat değeri geçersiz. Detay: Fiyat, izin verilen aralıkta değil"
                            e.message?.contains("insufficient balance") == true ->
                                "Hata: Yetersiz bakiye. Detay: İşlem için yeterli USDT bakiyeniz bulunmuyor"
                            e.message?.contains("PERCENT_PRICE") == true ->
                                "Hata: Fiyat aralık dışında. Detay: Belirlenen fiyat mevcut piyasa fiyatından çok uzak"
                            e.message?.contains("MIN_NOTIONAL") == true ->
                                "Hata: İşlem tutarı çok düşük. Detay: Minimum işlem tutarının altında"
                            e.message?.contains("MAX_NUM_ORDERS") == true ->
                                "Hata: Maksimum emir limiti. Detay: Açık emir sayınız limite ulaştı"
                            e.message?.contains("POSITION_SIDE") == true ->
                                "Hata: Pozisyon yönü hatası. Detay: Seçilen pozisyon yönü geçersiz"
                            e.message?.contains("REDUCE_ONLY") == true ->
                                "Hata: Pozisyon kapatma hatası. Detay: Kapatılacak pozisyon bulunamadı"
                            e.message?.contains("HTTP: 400") == true -> {
                                "Hata: İşlem talebi geçersiz. Lütfen parametrelerinizi kontrol ediniz. " +
                                (e.message?.let { message ->
                                    when {
                                        message.contains("body=") -> {
                                            "Detay: " + message.substringAfter("body=")
                                                .substringBefore("}")
                                                .replace("\"", "")
                                                .replace("{", "")
                                                .trim()
                                        }
                                        message.contains("msg=") -> {
                                            "Detay: " + message.substringAfter("msg=")
                                                .substringBefore(",")
                                                .replace("\"", "")
                                                .trim()
                                        }
                                        else -> "Detay: İşlem parametreleri geçersiz"
                                    }
                                } ?: "Detay: İşlem parametreleri geçersiz")
                            }
                            else -> {
                                // HTTP 400 hata mesajını detaylı olarak çıkart
                                val errorBody = e.message?.let { message ->
                                    when {
                                        message.contains("body=") -> {
                                            message.substringAfter("body=")
                                                .substringBefore("}")
                                                .replace("\"", "")
                                                .replace("{", "")
                                                .trim()
                                        }
                                        message.contains("msg=") -> {
                                            message.substringAfter("msg=")
                                                .substringBefore(",")
                                                .replace("\"", "")
                                                .trim()
                                        }
                                        else -> message
                                    }
                                } ?: "Detaylı hata bilgisi alınamadı"

                                val errorCode = e.message?.let { message ->
                                    message.substringAfter("code=")
                                        .substringBefore(",")
                                        .trim()
                                } ?: "400"

                                "Hata: İşlem başarısız (HTTP $errorCode)\nDetay: $errorBody"
                            }
                        }
                    }
                    e.message?.contains("timeout") == true ->
                        "Hata: Sunucu yanıt vermiyor. Detay: İşlem zaman aşımına uğradı, internet bağlantınızı kontrol edin"
                    e.message?.contains("5") == true ->
                        "Hata: Sunucu hatası. Detay: Binance'de geçici bir sorun oluştu, lütfen daha sonra tekrar deneyin"
                    else -> "Hata: ${e.message ?: "Bilinmeyen bir hata oluştu"}"
                }

                Timber.e(e, "İşlem gerçekleştirilirken hata: $errorMessage")
                _uiState.update {
                    it.copy(
                        lastTradeDetails = errorMessage,
                        isLoading = false
                    )
                }
            }
            scheduleMessageClear()
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


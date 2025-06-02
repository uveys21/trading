package com.uveys.trader.presentation.viewmodel;

import java.lang.System;

/**
 * Ana ekran için ViewModel
 */
@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J0\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020 J\b\u0010\"\u001a\u00020\u0016H\u0002J\u0010\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\'J\u000e\u0010(\u001a\u00020\u00162\u0006\u0010)\u001a\u00020*J\u0010\u0010+\u001a\u00020\u00162\b\u0010,\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010-\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010.\u001a\u00020\u0016J\u0006\u0010/\u001a\u00020\u0016J\u000e\u00100\u001a\u00020\u00162\u0006\u00101\u001a\u000202R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u00063"}, d2 = {"Lcom/uveys/trader/presentation/viewmodel/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "manualTradingUseCase", "Lcom/uveys/trader/domain/usecase/ManualTradingUseCase;", "strategyUseCase", "Lcom/uveys/trader/domain/usecase/TripleConfirmationStrategyUseCase;", "binanceRepository", "Lcom/uveys/trader/domain/repository/BinanceRepository;", "securePreferencesManager", "Lcom/uveys/trader/util/security/SecurePreferencesManager;", "(Lcom/uveys/trader/domain/usecase/ManualTradingUseCase;Lcom/uveys/trader/domain/usecase/TripleConfirmationStrategyUseCase;Lcom/uveys/trader/domain/repository/BinanceRepository;Lcom/uveys/trader/util/security/SecurePreferencesManager;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/uveys/trader/presentation/viewmodel/MainUiState;", "autoTradingJob", "Lkotlinx/coroutines/Job;", "strategyJob", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadInitialData", "", "logout", "placeOrder", "symbol", "", "side", "Lcom/uveys/trader/domain/entity/OrderSide;", "positionSide", "Lcom/uveys/trader/domain/entity/PositionSide;", "price", "Ljava/math/BigDecimal;", "quantity", "scheduleMessageClear", "setAutoTradePosition", "position", "setLeverage", "leverage", "", "setRiskPercentage", "percentage", "", "startAutoTrading", "targetPosition", "startStrategy", "stopAutoTrading", "stopStrategy", "toggleAutoTrade", "enabled", "", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    private final com.uveys.trader.domain.usecase.ManualTradingUseCase manualTradingUseCase = null;
    private final com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase strategyUseCase = null;
    private final com.uveys.trader.domain.repository.BinanceRepository binanceRepository = null;
    private final com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uveys.trader.presentation.viewmodel.MainUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uveys.trader.presentation.viewmodel.MainUiState> uiState = null;
    private kotlinx.coroutines.Job strategyJob;
    private kotlinx.coroutines.Job autoTradingJob;
    
    @javax.inject.Inject
    public MainViewModel(@org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.usecase.ManualTradingUseCase manualTradingUseCase, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase strategyUseCase, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.repository.BinanceRepository binanceRepository, @org.jetbrains.annotations.NotNull
    com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uveys.trader.presentation.viewmodel.MainUiState> getUiState() {
        return null;
    }
    
    /**
     * Başlangıç verilerini yükler
     */
    private final void loadInitialData() {
    }
    
    /**
     * Stratejiyi başlatır
     */
    public final void startStrategy(@org.jetbrains.annotations.NotNull
    java.lang.String symbol) {
    }
    
    /**
     * Stratejiyi durdurur
     */
    public final void stopStrategy() {
    }
    
    /**
     * Otomatik işlemeyi başlatır
     * @param targetPosition İşlem açılacak hedef pozisyon (LONG veya SHORT). Null ise tüm sinyallerde işlem açılır.
     */
    public final void startAutoTrading(@org.jetbrains.annotations.Nullable
    com.uveys.trader.domain.entity.PositionSide targetPosition) {
    }
    
    /**
     * Otomatik işlemeyi durdurur
     */
    public final void stopAutoTrading() {
    }
    
    /**
     * Otomatik işlem hedef pozisyonunu ayarlar
     */
    public final void setAutoTradePosition(@org.jetbrains.annotations.Nullable
    com.uveys.trader.domain.entity.PositionSide position) {
    }
    
    private final void scheduleMessageClear() {
    }
    
    /**
     * Manuel emir verir
     */
    public final void placeOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.Nullable
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity) {
    }
    
    /**
     * Kaldıraç oranını ayarlar
     */
    public final void setLeverage(int leverage) {
    }
    
    /**
     * Risk yüzdesini ayarlar
     */
    public final void setRiskPercentage(double percentage) {
    }
    
    /**
     * Otomatik işlem açma/kapama durumunu değiştirir
     */
    public final void toggleAutoTrade(boolean enabled) {
    }
    
    /**
     * Çıkış yapar
     */
    public final void logout() {
    }
}
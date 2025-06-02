package com.uveys.trader.presentation.viewmodel;

import java.lang.System;

/**
 * Giriş ekranı için ViewModel
 */
@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/uveys/trader/presentation/viewmodel/AuthViewModel;", "Landroidx/lifecycle/ViewModel;", "securePreferencesManager", "Lcom/uveys/trader/util/security/SecurePreferencesManager;", "(Lcom/uveys/trader/util/security/SecurePreferencesManager;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/uveys/trader/presentation/viewmodel/AuthUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "checkExistingCredentials", "", "saveApiCredentials", "apiKey", "", "apiSecret", "app_debug"})
public final class AuthViewModel extends androidx.lifecycle.ViewModel {
    private final com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.uveys.trader.presentation.viewmodel.AuthUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.uveys.trader.presentation.viewmodel.AuthUiState> uiState = null;
    
    @javax.inject.Inject
    public AuthViewModel(@org.jetbrains.annotations.NotNull
    com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.uveys.trader.presentation.viewmodel.AuthUiState> getUiState() {
        return null;
    }
    
    /**
     * Mevcut API anahtarlarını kontrol eder
     */
    private final void checkExistingCredentials() {
    }
    
    /**
     * API anahtarlarını kaydeder
     */
    public final void saveApiCredentials(@org.jetbrains.annotations.NotNull
    java.lang.String apiKey, @org.jetbrains.annotations.NotNull
    java.lang.String apiSecret) {
    }
}
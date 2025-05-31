package com.uveys.trader.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uveys.trader.util.security.SecurePreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * Giriş ekranı için ViewModel
 */
@HiltViewModel
class AuthViewModel @Inject constructor(
    private val securePreferencesManager: SecurePreferencesManager
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    init {
        checkExistingCredentials()
    }

    /**
     * Mevcut API anahtarlarını kontrol eder
     */
    private fun checkExistingCredentials() {
        viewModelScope.launch {
            try {
                val hasCredentials = securePreferencesManager.hasApiCredentials()
                if (hasCredentials) {
                    _uiState.update { it.copy(isAuthenticated = true) }
                }
            } catch (e: Exception) {
                Timber.e(e, "API anahtarları kontrol edilirken hata oluştu")
                _uiState.update { it.copy(errorMessage = "API anahtarları kontrol edilirken hata oluştu") }
            }
        }
    }

    /**
     * API anahtarlarını kaydeder
     */
    fun saveApiCredentials(apiKey: String, apiSecret: String) {
        viewModelScope.launch {
            try {
                _uiState.update { it.copy(isLoading = true, errorMessage = "") }
                
                // API anahtarlarını doğrula (basit kontrol)
                if (apiKey.length < 10 || apiSecret.length < 10) {
                    _uiState.update { 
                        it.copy(
                            isLoading = false, 
                            errorMessage = "Geçersiz API anahtarları. Lütfen kontrol ediniz."
                        ) 
                    }
                    return@launch
                }
                
                // API anahtarlarını kaydet
                securePreferencesManager.saveApiKey(apiKey)
                securePreferencesManager.saveApiSecret(apiSecret)
                
                _uiState.update { it.copy(isLoading = false, isAuthenticated = true) }
            } catch (e: Exception) {
                Timber.e(e, "API anahtarları kaydedilirken hata oluştu")
                _uiState.update { 
                    it.copy(
                        isLoading = false, 
                        errorMessage = "API anahtarları kaydedilirken hata oluştu: ${e.message}"
                    ) 
                }
            }
        }
    }
}

/**
 * Giriş ekranı UI durumu
 */
data class AuthUiState(
    val isLoading: Boolean = false,
    val isAuthenticated: Boolean = false,
    val errorMessage: String = ""
)

package com.uveys.trader.util.security

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * API anahtarlarını güvenli bir şekilde saklamak için şifreli SharedPreferences kullanımı
 */
@Singleton
class SecurePreferencesManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    
    companion object {
        private const val SECURE_PREFS_FILE = "secure_trader_prefs"
        private const val KEY_API_KEY = "api_key"
        private const val KEY_API_SECRET = "api_secret"
    }
    
    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()
    
    private val securePreferences = EncryptedSharedPreferences.create(
        context,
        SECURE_PREFS_FILE,
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    
    /**
     * API anahtarını güvenli bir şekilde kaydeder
     */
    fun saveApiKey(apiKey: String) {
        securePreferences.edit().putString(KEY_API_KEY, apiKey).apply()
    }
    
    /**
     * API gizli anahtarını güvenli bir şekilde kaydeder
     */
    fun saveApiSecret(apiSecret: String) {
        securePreferences.edit().putString(KEY_API_SECRET, apiSecret).apply()
    }
    
    /**
     * Kaydedilmiş API anahtarını getirir
     */
    fun getApiKey(): String? {
        return securePreferences.getString(KEY_API_KEY, null)
    }
    
    /**
     * Kaydedilmiş API gizli anahtarını getirir
     */
    fun getApiSecret(): String? {
        return securePreferences.getString(KEY_API_SECRET, null)
    }
    
    /**
     * API anahtarlarının kaydedilip kaydedilmediğini kontrol eder
     */
    fun hasApiCredentials(): Boolean {
        return !getApiKey().isNullOrEmpty() && !getApiSecret().isNullOrEmpty()
    }
    
    /**
     * Tüm API anahtarlarını siler
     */
    fun clearApiCredentials() {
        securePreferences.edit()
            .remove(KEY_API_KEY)
            .remove(KEY_API_SECRET)
            .apply()
    }
}

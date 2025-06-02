package com.uveys.trader.util.security;

import java.lang.System;

/**
 * API anahtarlarını güvenli bir şekilde saklamak için şifreli SharedPreferences kullanımı
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\fJ\u000e\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/uveys/trader/util/security/SecurePreferencesManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "masterKey", "Landroidx/security/crypto/MasterKey;", "securePreferences", "Landroid/content/SharedPreferences;", "clearApiCredentials", "", "getApiKey", "", "getApiSecret", "hasApiCredentials", "", "saveApiKey", "apiKey", "saveApiSecret", "apiSecret", "Companion", "app_debug"})
@javax.inject.Singleton
public final class SecurePreferencesManager {
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull
    public static final com.uveys.trader.util.security.SecurePreferencesManager.Companion Companion = null;
    private static final java.lang.String SECURE_PREFS_FILE = "secure_trader_prefs";
    private static final java.lang.String KEY_API_KEY = "api_key";
    private static final java.lang.String KEY_API_SECRET = "api_secret";
    private final androidx.security.crypto.MasterKey masterKey = null;
    private final android.content.SharedPreferences securePreferences = null;
    
    @javax.inject.Inject
    public SecurePreferencesManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        super();
    }
    
    /**
     * API anahtarını güvenli bir şekilde kaydeder
     */
    public final void saveApiKey(@org.jetbrains.annotations.NotNull
    java.lang.String apiKey) {
    }
    
    /**
     * API gizli anahtarını güvenli bir şekilde kaydeder
     */
    public final void saveApiSecret(@org.jetbrains.annotations.NotNull
    java.lang.String apiSecret) {
    }
    
    /**
     * Kaydedilmiş API anahtarını getirir
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getApiKey() {
        return null;
    }
    
    /**
     * Kaydedilmiş API gizli anahtarını getirir
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getApiSecret() {
        return null;
    }
    
    /**
     * API anahtarlarının kaydedilip kaydedilmediğini kontrol eder
     */
    public final boolean hasApiCredentials() {
        return false;
    }
    
    /**
     * Tüm API anahtarlarını siler
     */
    public final void clearApiCredentials() {
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/uveys/trader/util/security/SecurePreferencesManager$Companion;", "", "()V", "KEY_API_KEY", "", "KEY_API_SECRET", "SECURE_PREFS_FILE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
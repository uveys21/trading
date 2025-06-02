package com.uveys.trader.util.security;

import java.lang.System;

/**
 * Binance API isteklerine imza ekleyen OkHttp interceptor
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/uveys/trader/util/security/BinanceAuthInterceptor;", "Lokhttp3/Interceptor;", "securePreferencesManager", "Lcom/uveys/trader/util/security/SecurePreferencesManager;", "(Lcom/uveys/trader/util/security/SecurePreferencesManager;)V", "bytesToHex", "", "bytes", "", "generateSignature", "data", "key", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "app_debug"})
public final class BinanceAuthInterceptor implements okhttp3.Interceptor {
    private final com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager = null;
    
    @javax.inject.Inject
    public BinanceAuthInterceptor(@org.jetbrains.annotations.NotNull
    com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    /**
     * HMAC SHA256 imzası oluşturur
     */
    @kotlin.jvm.Throws(exceptionClasses = {java.security.NoSuchAlgorithmException.class, java.security.InvalidKeyException.class})
    private final java.lang.String generateSignature(java.lang.String data, java.lang.String key) throws java.security.NoSuchAlgorithmException, java.security.InvalidKeyException {
        return null;
    }
    
    /**
     * Byte dizisini hexadecimal string'e dönüştürür
     */
    private final java.lang.String bytesToHex(byte[] bytes) {
        return null;
    }
}
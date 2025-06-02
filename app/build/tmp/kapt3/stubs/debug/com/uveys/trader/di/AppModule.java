package com.uveys.trader.di;

import java.lang.System;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\fH\u0007J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0013\u001a\u00020\u0011H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0007J\u0018\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0015H\u0007J\u0012\u0010\u001c\u001a\u00020\n2\b\b\u0001\u0010\u001d\u001a\u00020\u001eH\u0007\u00a8\u0006\u001f"}, d2 = {"Lcom/uveys/trader/di/AppModule;", "", "()V", "provideBinanceApiService", "Lcom/uveys/trader/data/api/rest/BinanceApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideBinanceAuthInterceptor", "Lcom/uveys/trader/util/security/BinanceAuthInterceptor;", "securePreferencesManager", "Lcom/uveys/trader/util/security/SecurePreferencesManager;", "provideBinanceMapper", "Lcom/uveys/trader/data/mapper/BinanceMapper;", "provideBinanceRepository", "Lcom/uveys/trader/domain/repository/BinanceRepository;", "apiService", "webSocketManager", "Lcom/uveys/trader/data/api/websocket/BinanceWebSocketManager;", "mapper", "provideBinanceWebSocketManager", "provideGson", "Lcom/google/gson/Gson;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "binanceAuthInterceptor", "provideRetrofit", "okHttpClient", "gson", "provideSecurePreferencesManager", "context", "Landroid/content/Context;", "app_debug"})
@dagger.Module
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    public static final com.uveys.trader.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uveys.trader.util.security.SecurePreferencesManager provideSecurePreferencesManager(@org.jetbrains.annotations.NotNull
    @dagger.hilt.android.qualifiers.ApplicationContext
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uveys.trader.util.security.BinanceAuthInterceptor provideBinanceAuthInterceptor(@org.jetbrains.annotations.NotNull
    com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull
    com.uveys.trader.util.security.BinanceAuthInterceptor binanceAuthInterceptor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient, @org.jetbrains.annotations.NotNull
    com.google.gson.Gson gson) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uveys.trader.data.api.rest.BinanceApiService provideBinanceApiService(@org.jetbrains.annotations.NotNull
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uveys.trader.data.api.websocket.BinanceWebSocketManager provideBinanceWebSocketManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uveys.trader.data.mapper.BinanceMapper provideBinanceMapper() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @javax.inject.Singleton
    @dagger.Provides
    public final com.uveys.trader.domain.repository.BinanceRepository provideBinanceRepository(@org.jetbrains.annotations.NotNull
    com.uveys.trader.data.api.rest.BinanceApiService apiService, @org.jetbrains.annotations.NotNull
    com.uveys.trader.data.api.websocket.BinanceWebSocketManager webSocketManager, @org.jetbrains.annotations.NotNull
    com.uveys.trader.data.mapper.BinanceMapper mapper, @org.jetbrains.annotations.NotNull
    com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager) {
        return null;
    }
}
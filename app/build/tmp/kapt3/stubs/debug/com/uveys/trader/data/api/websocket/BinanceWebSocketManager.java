package com.uveys.trader.data.api.websocket;

import java.lang.System;

/**
 * Binance Futures WebSocket bağlantı yöneticisi
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\n\u001a\u00020\u000bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/uveys/trader/data/api/websocket/BinanceWebSocketManager;", "", "()V", "webSocketClient", "Lorg/java_websocket/client/WebSocketClient;", "closeConnection", "", "subscribeToKlines", "Lkotlinx/coroutines/flow/Flow;", "Lcom/uveys/trader/data/dto/CandleDto;", "symbol", "", "interval", "subscribeToPriceStream", "Ljava/math/BigDecimal;", "app_debug"})
@javax.inject.Singleton
public final class BinanceWebSocketManager {
    private org.java_websocket.client.WebSocketClient webSocketClient;
    
    @javax.inject.Inject
    public BinanceWebSocketManager() {
        super();
    }
    
    /**
     * Belirli bir sembol ve zaman aralığı için gerçek zamanlı mum verilerini akış olarak alır
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı
     * @return Mum verisi akışı
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.uveys.trader.data.dto.CandleDto> subscribeToKlines(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval) {
        return null;
    }
    
    /**
     * Belirli bir sembol için anlık fiyat bilgisini akış olarak alır
     * @param symbol Kripto para çifti
     * @return Fiyat akışı
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.math.BigDecimal> subscribeToPriceStream(@org.jetbrains.annotations.NotNull
    java.lang.String symbol) {
        return null;
    }
    
    /**
     * WebSocket bağlantısını kapatır
     */
    public final void closeConnection() {
    }
}
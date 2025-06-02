package com.uveys.trader.data.repository;

import java.lang.System;

/**
 * BinanceRepository arayüzünün uygulaması
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ9\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J1\u0010\u0017\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J9\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J9\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u001c\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ/\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J\u001e\u0010%\u001a\b\u0012\u0004\u0012\u00020 0&2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u000eH\u0016J\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020(0\u001fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\'\u0010)\u001a\b\u0012\u0004\u0012\u00020\f0\u001f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010,J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00140&2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0011\u0010.\u001a\u00020/H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ!\u00100\u001a\u00020/2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u00101\u001a\u00020#H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/uveys/trader/data/repository/BinanceRepositoryImpl;", "Lcom/uveys/trader/domain/repository/BinanceRepository;", "apiService", "Lcom/uveys/trader/data/api/rest/BinanceApiService;", "webSocketManager", "Lcom/uveys/trader/data/api/websocket/BinanceWebSocketManager;", "mapper", "Lcom/uveys/trader/data/mapper/BinanceMapper;", "securePreferencesManager", "Lcom/uveys/trader/util/security/SecurePreferencesManager;", "(Lcom/uveys/trader/data/api/rest/BinanceApiService;Lcom/uveys/trader/data/api/websocket/BinanceWebSocketManager;Lcom/uveys/trader/data/mapper/BinanceMapper;Lcom/uveys/trader/util/security/SecurePreferencesManager;)V", "createLimitOrder", "Lcom/uveys/trader/domain/entity/Order;", "symbol", "", "side", "Lcom/uveys/trader/domain/entity/OrderSide;", "positionSide", "Lcom/uveys/trader/domain/entity/PositionSide;", "price", "Ljava/math/BigDecimal;", "quantity", "(Ljava/lang/String;Lcom/uveys/trader/domain/entity/OrderSide;Lcom/uveys/trader/domain/entity/PositionSide;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMarketOrder", "(Ljava/lang/String;Lcom/uveys/trader/domain/entity/OrderSide;Lcom/uveys/trader/domain/entity/PositionSide;Ljava/math/BigDecimal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStopLossOrder", "stopPrice", "createTakeProfitOrder", "getAccountBalance", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKlines", "", "Lcom/uveys/trader/domain/entity/Candle;", "interval", "limit", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKlinesStream", "Lkotlinx/coroutines/flow/Flow;", "getOpenPositions", "Lcom/uveys/trader/domain/entity/Position;", "getOrderHistory", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPriceStream", "ping", "", "setLeverage", "leverage", "app_debug"})
@javax.inject.Singleton
public final class BinanceRepositoryImpl implements com.uveys.trader.domain.repository.BinanceRepository {
    private final com.uveys.trader.data.api.rest.BinanceApiService apiService = null;
    private final com.uveys.trader.data.api.websocket.BinanceWebSocketManager webSocketManager = null;
    private final com.uveys.trader.data.mapper.BinanceMapper mapper = null;
    private final com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager = null;
    
    @javax.inject.Inject
    public BinanceRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.uveys.trader.data.api.rest.BinanceApiService apiService, @org.jetbrains.annotations.NotNull
    com.uveys.trader.data.api.websocket.BinanceWebSocketManager webSocketManager, @org.jetbrains.annotations.NotNull
    com.uveys.trader.data.mapper.BinanceMapper mapper, @org.jetbrains.annotations.NotNull
    com.uveys.trader.util.security.SecurePreferencesManager securePreferencesManager) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getKlines(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Candle>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<com.uveys.trader.domain.entity.Candle> getKlinesStream(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getPrice(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.math.BigDecimal> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getPriceStream(@org.jetbrains.annotations.NotNull
    java.lang.String symbol) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getAccountBalance(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.math.BigDecimal> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getOpenPositions(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Position>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object createMarketOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object createLimitOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object createStopLossOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal stopPrice, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object createTakeProfitOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object setLeverage(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, int leverage, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object getOrderHistory(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Order>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public java.lang.Object ping(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
}
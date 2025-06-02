package com.uveys.trader.data.api.rest;

import java.lang.System;

/**
 * Binance Futures REST API servisi
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001Ja\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\u000b\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJM\u0010\u000f\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010JW\u0010\u0011\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\u0012\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013JW\u0010\u0014\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\u00052\b\b\u0001\u0010\b\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\u00052\b\b\u0001\u0010\n\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\'\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J;\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00190\u00192\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001cH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001fJ!\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u00192\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\u001b\u0010\"\u001a\u00020#2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010$J;\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u00162\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010&\u001a\u00020\u001c2\b\b\u0001\u0010\f\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\'"}, d2 = {"Lcom/uveys/trader/data/api/rest/BinanceApiService;", "", "createLimitOrder", "Lcom/uveys/trader/data/dto/OrderDto;", "symbol", "", "side", "type", "positionSide", "price", "quantity", "timeInForce", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMarketOrder", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStopLossOrder", "stopPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createTakeProfitOrder", "getAccount", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKlines", "", "interval", "limit", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOrderHistory", "(Ljava/lang/String;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPositions", "Lcom/uveys/trader/data/dto/PositionDto;", "getPrice", "Lcom/uveys/trader/data/dto/PriceDto;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setLeverage", "leverage", "app_debug"})
public abstract interface BinanceApiService {
    
    /**
     * Mum verilerini getirir
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı (örn. "15m", "1h", "4h", "1d")
     * @param limit Getirilecek mum sayısı
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "fapi/v1/klines")
    public abstract java.lang.Object getKlines(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "interval")
    java.lang.String interval, @retrofit2.http.Query(value = "limit")
    int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<? extends java.util.List<? extends java.lang.Object>>> continuation);
    
    /**
     * Anlık fiyat bilgisini getirir
     * @param symbol Kripto para çifti
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "fapi/v1/ticker/price")
    public abstract java.lang.Object getPrice(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.data.dto.PriceDto> continuation);
    
    /**
     * Hesap bilgilerini getirir
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "fapi/v2/account")
    public abstract java.lang.Object getAccount(@retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> continuation);
    
    /**
     * Pozisyon bilgilerini getirir
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "fapi/v2/positionRisk")
    public abstract java.lang.Object getPositions(@retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.data.dto.PositionDto>> continuation);
    
    /**
     * Market emri oluşturur
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "fapi/v1/order")
    public abstract java.lang.Object createMarketOrder(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "side")
    java.lang.String side, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "positionSide")
    java.lang.String positionSide, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "quantity")
    java.lang.String quantity, @retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.data.dto.OrderDto> continuation);
    
    /**
     * Limit emri oluşturur
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "fapi/v1/order")
    public abstract java.lang.Object createLimitOrder(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "side")
    java.lang.String side, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "positionSide")
    java.lang.String positionSide, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "price")
    java.lang.String price, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "quantity")
    java.lang.String quantity, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "timeInForce")
    java.lang.String timeInForce, @retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.data.dto.OrderDto> continuation);
    
    /**
     * Stop-loss emri oluşturur
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "fapi/v1/order")
    public abstract java.lang.Object createStopLossOrder(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "side")
    java.lang.String side, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "positionSide")
    java.lang.String positionSide, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "stopPrice")
    java.lang.String stopPrice, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "quantity")
    java.lang.String quantity, @retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.data.dto.OrderDto> continuation);
    
    /**
     * Take-profit emri oluşturur
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "fapi/v1/order")
    public abstract java.lang.Object createTakeProfitOrder(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "side")
    java.lang.String side, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "type")
    java.lang.String type, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "positionSide")
    java.lang.String positionSide, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "price")
    java.lang.String price, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "quantity")
    java.lang.String quantity, @retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.data.dto.OrderDto> continuation);
    
    /**
     * Kaldıraç oranını ayarlar
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "fapi/v1/leverage")
    public abstract java.lang.Object setLeverage(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @retrofit2.http.Query(value = "leverage")
    int leverage, @retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, ? extends java.lang.Object>> continuation);
    
    /**
     * Emir geçmişini getirir
     */
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.GET(value = "fapi/v1/allOrders")
    public abstract java.lang.Object getOrderHistory(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Query(value = "symbol")
    java.lang.String symbol, @retrofit2.http.Query(value = "limit")
    int limit, @retrofit2.http.Query(value = "timestamp")
    long timestamp, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.data.dto.OrderDto>> continuation);
}
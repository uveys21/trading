package com.uveys.trader.domain.repository;

import java.lang.System;

/**
 * Binance Futures API ile iletişim için repository arayüzü
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ1\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ9\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ9\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\u0011\u0010\u0013\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J/\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u001d2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H&J\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\'\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00030\u00162\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010#J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001d2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J\u0011\u0010&\u001a\u00020\'H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0014J!\u0010(\u001a\u00020\'2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u001aH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006*"}, d2 = {"Lcom/uveys/trader/domain/repository/BinanceRepository;", "", "createLimitOrder", "Lcom/uveys/trader/domain/entity/Order;", "symbol", "", "side", "Lcom/uveys/trader/domain/entity/OrderSide;", "positionSide", "Lcom/uveys/trader/domain/entity/PositionSide;", "price", "Ljava/math/BigDecimal;", "quantity", "(Ljava/lang/String;Lcom/uveys/trader/domain/entity/OrderSide;Lcom/uveys/trader/domain/entity/PositionSide;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMarketOrder", "(Ljava/lang/String;Lcom/uveys/trader/domain/entity/OrderSide;Lcom/uveys/trader/domain/entity/PositionSide;Ljava/math/BigDecimal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStopLossOrder", "stopPrice", "createTakeProfitOrder", "getAccountBalance", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKlines", "", "Lcom/uveys/trader/domain/entity/Candle;", "interval", "limit", "", "(Ljava/lang/String;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getKlinesStream", "Lkotlinx/coroutines/flow/Flow;", "getOpenPositions", "Lcom/uveys/trader/domain/entity/Position;", "getOrderHistory", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrice", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPriceStream", "getTradingPairs", "ping", "", "setLeverage", "leverage", "app_debug"})
public abstract interface BinanceRepository {
    
    /**
     * Belirli bir sembol ve zaman aralığı için mum verilerini getirir
     * @param symbol Kripto para çifti (örn. "BTCUSDT")
     * @param interval Zaman aralığı (örn. "15m", "1h", "4h", "1d")
     * @param limit Getirilecek mum sayısı
     * @return Mum listesi
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getKlines(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Candle>> continuation);
    
    /**
     * Belirli bir sembol ve zaman aralığı için gerçek zamanlı mum verilerini akış olarak alır
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı
     * @return Mum verisi akışı
     */
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<com.uveys.trader.domain.entity.Candle> getKlinesStream(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval);
    
    /**
     * Belirli bir sembol için anlık fiyat bilgisini getirir
     * @param symbol Kripto para çifti
     * @return Anlık fiyat
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getPrice(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.math.BigDecimal> continuation);
    
    /**
     * Belirli bir sembol için anlık fiyat bilgisini akış olarak alır
     * @param symbol Kripto para çifti
     * @return Fiyat akışı
     */
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.math.BigDecimal> getPriceStream(@org.jetbrains.annotations.NotNull
    java.lang.String symbol);
    
    /**
     * Hesap bakiyesini getirir
     * @return Bakiye miktarı
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getAccountBalance(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.math.BigDecimal> continuation);
    
    /**
     * Açık pozisyonları getirir
     * @return Açık pozisyonlar
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOpenPositions(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Position>> continuation);
    
    /**
     * Market emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object createMarketOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation);
    
    /**
     * Limit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Fiyat
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object createLimitOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation);
    
    /**
     * Stop-loss emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param stopPrice Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object createStopLossOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal stopPrice, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation);
    
    /**
     * Take-profit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object createTakeProfitOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation);
    
    /**
     * Kaldıraç oranını ayarlar
     * @param symbol Kripto para çifti
     * @param leverage Kaldıraç oranı
     * @return İşlem başarılı mı
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setLeverage(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, int leverage, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
    
    /**
     * Emir geçmişini getirir
     * @param symbol Kripto para çifti
     * @param limit Getirilecek emir sayısı
     * @return Emir listesi
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getOrderHistory(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Order>> continuation);
    
    /**
     * API bağlantısının durumunu kontrol eder
     * @return true: Bağlantı aktif, false: Bağlantı yok
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object ping(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation);
    
    /**
     * Tüm ticari çiftleri getirir
     * @return Ticari çiftler listesi
     */
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getTradingPairs(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.String>> continuation);
}
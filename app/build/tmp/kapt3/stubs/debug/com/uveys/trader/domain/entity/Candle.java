package com.uveys.trader.domain.entity;

import java.lang.System;

/**
 * Mum (Candlestick) veri modeli
 * Teknik analiz için kullanılacak temel veri yapısı
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0010J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0005H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\u0005H\u00c6\u0003J\t\u0010.\u001a\u00020\u0003H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\t\u00100\u001a\u00020\rH\u00c6\u0003Jw\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u0005H\u00c6\u0001J\u0013\u00102\u001a\u00020\u001b2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\rH\u00d6\u0001J\t\u00105\u001a\u000206H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\u001a\u001a\u00020\u001b8F\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0012R\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0012\u00a8\u00067"}, d2 = {"Lcom/uveys/trader/domain/entity/Candle;", "", "openTime", "", "open", "Ljava/math/BigDecimal;", "high", "low", "close", "volume", "closeTime", "quoteAssetVolume", "numberOfTrades", "", "takerBuyBaseAssetVolume", "takerBuyQuoteAssetVolume", "(JLjava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;JLjava/math/BigDecimal;ILjava/math/BigDecimal;Ljava/math/BigDecimal;)V", "getClose", "()Ljava/math/BigDecimal;", "getCloseTime", "()J", "date", "Ljava/util/Date;", "getDate", "()Ljava/util/Date;", "getHigh", "isGreen", "", "()Z", "getLow", "getNumberOfTrades", "()I", "getOpen", "getOpenTime", "getQuoteAssetVolume", "getTakerBuyBaseAssetVolume", "getTakerBuyQuoteAssetVolume", "getVolume", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class Candle {
    private final long openTime = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal open = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal high = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal low = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal close = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal volume = null;
    private final long closeTime = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal quoteAssetVolume = null;
    private final int numberOfTrades = 0;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal takerBuyBaseAssetVolume = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal takerBuyQuoteAssetVolume = null;
    
    /**
     * Mum (Candlestick) veri modeli
     * Teknik analiz için kullanılacak temel veri yapısı
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.Candle copy(long openTime, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal open, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal high, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal low, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal close, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal volume, long closeTime, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quoteAssetVolume, int numberOfTrades, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal takerBuyBaseAssetVolume, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal takerBuyQuoteAssetVolume) {
        return null;
    }
    
    /**
     * Mum (Candlestick) veri modeli
     * Teknik analiz için kullanılacak temel veri yapısı
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Mum (Candlestick) veri modeli
     * Teknik analiz için kullanılacak temel veri yapısı
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Mum (Candlestick) veri modeli
     * Teknik analiz için kullanılacak temel veri yapısı
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Candle(long openTime, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal open, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal high, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal low, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal close, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal volume, long closeTime, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quoteAssetVolume, int numberOfTrades, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal takerBuyBaseAssetVolume, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal takerBuyQuoteAssetVolume) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getOpenTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getOpen() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getHigh() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getLow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getClose() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getVolume() {
        return null;
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final long getCloseTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getQuoteAssetVolume() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getNumberOfTrades() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getTakerBuyBaseAssetVolume() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getTakerBuyQuoteAssetVolume() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Date getDate() {
        return null;
    }
    
    public final boolean isGreen() {
        return false;
    }
}
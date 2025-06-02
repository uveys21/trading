package com.uveys.trader.domain.entity;

import java.lang.System;

/**
 * Teknik gösterge sonuçları için veri modeli
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0006H\u00c6\u0003J\u0015\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0003J=\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u001bH\u00d6\u0001J\u0006\u0010\u001c\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0018J\t\u0010\u001e\u001a\u00020\u0003H\u00d6\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/uveys/trader/domain/entity/TechnicalIndicator;", "", "symbol", "", "interval", "timestamp", "", "indicators", "", "Ljava/math/BigDecimal;", "(Ljava/lang/String;Ljava/lang/String;JLjava/util/Map;)V", "getIndicators", "()Ljava/util/Map;", "getInterval", "()Ljava/lang/String;", "getSymbol", "getTimestamp", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "isLongSignal", "isShortSignal", "toString", "Companion", "app_debug"})
public final class TechnicalIndicator {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String symbol = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String interval = null;
    private final long timestamp = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.util.Map<java.lang.String, java.math.BigDecimal> indicators = null;
    @org.jetbrains.annotations.NotNull
    public static final com.uveys.trader.domain.entity.TechnicalIndicator.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EMA_50 = "ema50";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String EMA_200 = "ema200";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String RSI = "rsi";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MACD_LINE = "macdLine";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MACD_SIGNAL = "macdSignal";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String MACD_HISTOGRAM = "macdHistogram";
    
    /**
     * Teknik gösterge sonuçları için veri modeli
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.TechnicalIndicator copy(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval, long timestamp, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.math.BigDecimal> indicators) {
        return null;
    }
    
    /**
     * Teknik gösterge sonuçları için veri modeli
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Teknik gösterge sonuçları için veri modeli
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Teknik gösterge sonuçları için veri modeli
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public TechnicalIndicator(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval, long timestamp, @org.jetbrains.annotations.NotNull
    java.util.Map<java.lang.String, ? extends java.math.BigDecimal> indicators) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSymbol() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getInterval() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getTimestamp() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.math.BigDecimal> component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.Map<java.lang.String, java.math.BigDecimal> getIndicators() {
        return null;
    }
    
    public final boolean isLongSignal() {
        return false;
    }
    
    public final boolean isShortSignal() {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/uveys/trader/domain/entity/TechnicalIndicator$Companion;", "", "()V", "EMA_200", "", "EMA_50", "MACD_HISTOGRAM", "MACD_LINE", "MACD_SIGNAL", "RSI", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
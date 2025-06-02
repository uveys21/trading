package com.uveys.trader.data.dto;

import java.lang.System;

/**
 * Binance API'den gelen mum verisi DTO'su
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010#\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\rH\u00c6\u0003J\u0087\u0001\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001J\u0013\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010.\u001a\u00020\rH\u00d6\u0001J\t\u0010/\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012\u00a8\u00060"}, d2 = {"Lcom/uveys/trader/data/dto/CandleDto;", "", "openTime", "", "open", "", "high", "low", "close", "volume", "closeTime", "quoteAssetVolume", "numberOfTrades", "", "takerBuyBaseAssetVolume", "takerBuyQuoteAssetVolume", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "getClose", "()Ljava/lang/String;", "getCloseTime", "()J", "getHigh", "getLow", "getNumberOfTrades", "()I", "getOpen", "getOpenTime", "getQuoteAssetVolume", "getTakerBuyBaseAssetVolume", "getTakerBuyQuoteAssetVolume", "getVolume", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class CandleDto {
    @com.google.gson.annotations.SerializedName(value = "t")
    private final long openTime = 0L;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "o")
    private final java.lang.String open = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "h")
    private final java.lang.String high = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "l")
    private final java.lang.String low = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "c")
    private final java.lang.String close = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "v")
    private final java.lang.String volume = null;
    @com.google.gson.annotations.SerializedName(value = "T")
    private final long closeTime = 0L;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "q")
    private final java.lang.String quoteAssetVolume = null;
    @com.google.gson.annotations.SerializedName(value = "n")
    private final int numberOfTrades = 0;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "V")
    private final java.lang.String takerBuyBaseAssetVolume = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "Q")
    private final java.lang.String takerBuyQuoteAssetVolume = null;
    
    /**
     * Binance API'den gelen mum verisi DTO'su
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.data.dto.CandleDto copy(long openTime, @org.jetbrains.annotations.Nullable
    java.lang.String open, @org.jetbrains.annotations.Nullable
    java.lang.String high, @org.jetbrains.annotations.Nullable
    java.lang.String low, @org.jetbrains.annotations.Nullable
    java.lang.String close, @org.jetbrains.annotations.Nullable
    java.lang.String volume, long closeTime, @org.jetbrains.annotations.Nullable
    java.lang.String quoteAssetVolume, int numberOfTrades, @org.jetbrains.annotations.Nullable
    java.lang.String takerBuyBaseAssetVolume, @org.jetbrains.annotations.Nullable
    java.lang.String takerBuyQuoteAssetVolume) {
        return null;
    }
    
    /**
     * Binance API'den gelen mum verisi DTO'su
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Binance API'den gelen mum verisi DTO'su
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Binance API'den gelen mum verisi DTO'su
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public CandleDto(long openTime, @org.jetbrains.annotations.Nullable
    java.lang.String open, @org.jetbrains.annotations.Nullable
    java.lang.String high, @org.jetbrains.annotations.Nullable
    java.lang.String low, @org.jetbrains.annotations.Nullable
    java.lang.String close, @org.jetbrains.annotations.Nullable
    java.lang.String volume, long closeTime, @org.jetbrains.annotations.Nullable
    java.lang.String quoteAssetVolume, int numberOfTrades, @org.jetbrains.annotations.Nullable
    java.lang.String takerBuyBaseAssetVolume, @org.jetbrains.annotations.Nullable
    java.lang.String takerBuyQuoteAssetVolume) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getOpenTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getOpen() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getHigh() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getLow() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getClose() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getVolume() {
        return null;
    }
    
    public final long component7() {
        return 0L;
    }
    
    public final long getCloseTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getQuoteAssetVolume() {
        return null;
    }
    
    public final int component9() {
        return 0;
    }
    
    public final int getNumberOfTrades() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTakerBuyBaseAssetVolume() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getTakerBuyQuoteAssetVolume() {
        return null;
    }
}
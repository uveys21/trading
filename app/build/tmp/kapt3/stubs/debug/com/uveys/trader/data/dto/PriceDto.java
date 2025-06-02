package com.uveys.trader.data.dto;

import java.lang.System;

/**
 * Binance API'den gelen fiyat verisi DTO'su
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u001f\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lcom/uveys/trader/data/dto/PriceDto;", "", "symbol", "", "price", "(Ljava/lang/String;Ljava/lang/String;)V", "getPrice", "()Ljava/lang/String;", "getSymbol", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class PriceDto {
    @org.jetbrains.annotations.NotNull
    @com.google.gson.annotations.SerializedName(value = "symbol")
    private final java.lang.String symbol = null;
    @org.jetbrains.annotations.Nullable
    @com.google.gson.annotations.SerializedName(value = "price")
    private final java.lang.String price = null;
    
    /**
     * Binance API'den gelen fiyat verisi DTO'su
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.data.dto.PriceDto copy(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.Nullable
    java.lang.String price) {
        return null;
    }
    
    /**
     * Binance API'den gelen fiyat verisi DTO'su
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Binance API'den gelen fiyat verisi DTO'su
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Binance API'den gelen fiyat verisi DTO'su
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public PriceDto(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.Nullable
    java.lang.String price) {
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
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getPrice() {
        return null;
    }
}
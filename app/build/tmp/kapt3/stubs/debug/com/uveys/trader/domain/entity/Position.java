package com.uveys.trader.domain.entity;

import java.lang.System;

/**
 * İşlem pozisyonu veri modeli
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b \b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0010H\u00c6\u0003J\t\u0010(\u001a\u00020\u0005H\u00c6\u0003J\t\u0010)\u001a\u00020\u0007H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\nH\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\t\u0010-\u001a\u00020\u0003H\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003Jm\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001J\u0013\u00101\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00103\u001a\u00020\nH\u00d6\u0001J\t\u00104\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00158F\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016R\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u00078F\u00a2\u0006\u0006\u001a\u0004\b!\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0013R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u00065"}, d2 = {"Lcom/uveys/trader/domain/entity/Position;", "", "symbol", "", "positionSide", "Lcom/uveys/trader/domain/entity/PositionSide;", "entryPrice", "Ljava/math/BigDecimal;", "markPrice", "leverage", "", "unrealizedProfit", "marginType", "isolatedMargin", "positionAmt", "updateTime", "", "(Ljava/lang/String;Lcom/uveys/trader/domain/entity/PositionSide;Ljava/math/BigDecimal;Ljava/math/BigDecimal;ILjava/math/BigDecimal;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;J)V", "getEntryPrice", "()Ljava/math/BigDecimal;", "isInProfit", "", "()Z", "getIsolatedMargin", "getLeverage", "()I", "getMarginType", "()Ljava/lang/String;", "getMarkPrice", "getPositionAmt", "getPositionSide", "()Lcom/uveys/trader/domain/entity/PositionSide;", "profitPercentage", "getProfitPercentage", "getSymbol", "getUnrealizedProfit", "getUpdateTime", "()J", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class Position {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String symbol = null;
    @org.jetbrains.annotations.NotNull
    private final com.uveys.trader.domain.entity.PositionSide positionSide = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal entryPrice = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal markPrice = null;
    private final int leverage = 0;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal unrealizedProfit = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String marginType = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal isolatedMargin = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal positionAmt = null;
    private final long updateTime = 0L;
    
    /**
     * İşlem pozisyonu veri modeli
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.Position copy(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal entryPrice, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal markPrice, int leverage, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal unrealizedProfit, @org.jetbrains.annotations.NotNull
    java.lang.String marginType, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal isolatedMargin, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal positionAmt, long updateTime) {
        return null;
    }
    
    /**
     * İşlem pozisyonu veri modeli
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * İşlem pozisyonu veri modeli
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * İşlem pozisyonu veri modeli
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Position(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal entryPrice, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal markPrice, int leverage, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal unrealizedProfit, @org.jetbrains.annotations.NotNull
    java.lang.String marginType, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal isolatedMargin, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal positionAmt, long updateTime) {
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
    public final com.uveys.trader.domain.entity.PositionSide component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.PositionSide getPositionSide() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getEntryPrice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getMarkPrice() {
        return null;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final int getLeverage() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getUnrealizedProfit() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMarginType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getIsolatedMargin() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getPositionAmt() {
        return null;
    }
    
    public final long component10() {
        return 0L;
    }
    
    public final long getUpdateTime() {
        return 0L;
    }
    
    public final boolean isInProfit() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getProfitPercentage() {
        return null;
    }
}
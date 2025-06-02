package com.uveys.trader.domain.entity;

import java.lang.System;

/**
 * Emir veri modeli
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b4\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0095\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\u0006\u0010\u0017\u001a\u00020\u0018\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001a\u001a\u00020\u0005\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\u0002\u0010\u001cJ\t\u00107\u001a\u00020\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0011H\u00c6\u0003J\t\u00109\u001a\u00020\nH\u00c6\u0003J\t\u0010:\u001a\u00020\u0003H\u00c6\u0003J\t\u0010;\u001a\u00020\u0003H\u00c6\u0003J\t\u0010<\u001a\u00020\u0016H\u00c6\u0003J\t\u0010=\u001a\u00020\u0018H\u00c6\u0003J\t\u0010>\u001a\u00020\u0018H\u00c6\u0003J\t\u0010?\u001a\u00020\u0005H\u00c6\u0003J\t\u0010@\u001a\u00020\u0018H\u00c6\u0003J\t\u0010A\u001a\u00020\u0005H\u00c6\u0003J\t\u0010B\u001a\u00020\u0007H\u00c6\u0003J\t\u0010C\u001a\u00020\u0005H\u00c6\u0003J\t\u0010D\u001a\u00020\nH\u00c6\u0003J\t\u0010E\u001a\u00020\nH\u00c6\u0003J\t\u0010F\u001a\u00020\nH\u00c6\u0003J\t\u0010G\u001a\u00020\nH\u00c6\u0003J\t\u0010H\u001a\u00020\u000fH\u00c6\u0003J\u00bd\u0001\u0010I\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u00052\b\b\u0002\u0010\u001b\u001a\u00020\u0018H\u00c6\u0001J\u0013\u0010J\u001a\u00020\u00182\b\u0010K\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010L\u001a\u00020MH\u00d6\u0001J\t\u0010N\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u0015\u001a\u00020\u0016\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\u001b\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0012\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010 R\u0011\u0010\u0013\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010%R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010%R\u0011\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010 \u00a8\u0006O"}, d2 = {"Lcom/uveys/trader/domain/entity/Order;", "", "orderId", "", "symbol", "", "status", "Lcom/uveys/trader/domain/entity/OrderStatus;", "clientOrderId", "price", "Ljava/math/BigDecimal;", "avgPrice", "origQty", "executedQty", "type", "Lcom/uveys/trader/domain/entity/OrderType;", "side", "Lcom/uveys/trader/domain/entity/OrderSide;", "stopPrice", "time", "updateTime", "positionSide", "Lcom/uveys/trader/domain/entity/PositionSide;", "closePosition", "", "reduceOnly", "workingType", "priceProtect", "(JLjava/lang/String;Lcom/uveys/trader/domain/entity/OrderStatus;Ljava/lang/String;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lcom/uveys/trader/domain/entity/OrderType;Lcom/uveys/trader/domain/entity/OrderSide;Ljava/math/BigDecimal;JJLcom/uveys/trader/domain/entity/PositionSide;ZZLjava/lang/String;Z)V", "getAvgPrice", "()Ljava/math/BigDecimal;", "getClientOrderId", "()Ljava/lang/String;", "getClosePosition", "()Z", "getExecutedQty", "getOrderId", "()J", "getOrigQty", "getPositionSide", "()Lcom/uveys/trader/domain/entity/PositionSide;", "getPrice", "getPriceProtect", "getReduceOnly", "getSide", "()Lcom/uveys/trader/domain/entity/OrderSide;", "getStatus", "()Lcom/uveys/trader/domain/entity/OrderStatus;", "getStopPrice", "getSymbol", "getTime", "getType", "()Lcom/uveys/trader/domain/entity/OrderType;", "getUpdateTime", "getWorkingType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class Order {
    private final long orderId = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String symbol = null;
    @org.jetbrains.annotations.NotNull
    private final com.uveys.trader.domain.entity.OrderStatus status = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String clientOrderId = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal price = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal avgPrice = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal origQty = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal executedQty = null;
    @org.jetbrains.annotations.NotNull
    private final com.uveys.trader.domain.entity.OrderType type = null;
    @org.jetbrains.annotations.NotNull
    private final com.uveys.trader.domain.entity.OrderSide side = null;
    @org.jetbrains.annotations.NotNull
    private final java.math.BigDecimal stopPrice = null;
    private final long time = 0L;
    private final long updateTime = 0L;
    @org.jetbrains.annotations.NotNull
    private final com.uveys.trader.domain.entity.PositionSide positionSide = null;
    private final boolean closePosition = false;
    private final boolean reduceOnly = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String workingType = null;
    private final boolean priceProtect = false;
    
    /**
     * Emir veri modeli
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.Order copy(long orderId, @org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderStatus status, @org.jetbrains.annotations.NotNull
    java.lang.String clientOrderId, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal avgPrice, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal origQty, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal executedQty, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderType type, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal stopPrice, long time, long updateTime, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, boolean closePosition, boolean reduceOnly, @org.jetbrains.annotations.NotNull
    java.lang.String workingType, boolean priceProtect) {
        return null;
    }
    
    /**
     * Emir veri modeli
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Emir veri modeli
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Emir veri modeli
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public Order(long orderId, @org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderStatus status, @org.jetbrains.annotations.NotNull
    java.lang.String clientOrderId, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal avgPrice, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal origQty, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal executedQty, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderType type, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal stopPrice, long time, long updateTime, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, boolean closePosition, boolean reduceOnly, @org.jetbrains.annotations.NotNull
    java.lang.String workingType, boolean priceProtect) {
        super();
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long getOrderId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSymbol() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.OrderStatus component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.OrderStatus getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getClientOrderId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getPrice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getAvgPrice() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getOrigQty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getExecutedQty() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.OrderType component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.OrderType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.OrderSide component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.OrderSide getSide() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.math.BigDecimal getStopPrice() {
        return null;
    }
    
    public final long component12() {
        return 0L;
    }
    
    public final long getTime() {
        return 0L;
    }
    
    public final long component13() {
        return 0L;
    }
    
    public final long getUpdateTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.PositionSide component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.PositionSide getPositionSide() {
        return null;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean getClosePosition() {
        return false;
    }
    
    public final boolean component16() {
        return false;
    }
    
    public final boolean getReduceOnly() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getWorkingType() {
        return null;
    }
    
    public final boolean component18() {
        return false;
    }
    
    public final boolean getPriceProtect() {
        return false;
    }
}
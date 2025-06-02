package com.uveys.trader.domain.usecase;

import java.lang.System;

/**
 * İşlem sonucu veri sınıfı
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lcom/uveys/trader/domain/usecase/TradeResult;", "", "success", "", "message", "", "entryOrderId", "", "stopLossOrderId", "takeProfitOrderId", "(ZLjava/lang/String;JJJ)V", "getEntryOrderId", "()J", "getMessage", "()Ljava/lang/String;", "getStopLossOrderId", "getSuccess", "()Z", "getTakeProfitOrderId", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class TradeResult {
    private final boolean success = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String message = null;
    private final long entryOrderId = 0L;
    private final long stopLossOrderId = 0L;
    private final long takeProfitOrderId = 0L;
    
    /**
     * İşlem sonucu veri sınıfı
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.usecase.TradeResult copy(boolean success, @org.jetbrains.annotations.NotNull
    java.lang.String message, long entryOrderId, long stopLossOrderId, long takeProfitOrderId) {
        return null;
    }
    
    /**
     * İşlem sonucu veri sınıfı
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * İşlem sonucu veri sınıfı
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * İşlem sonucu veri sınıfı
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public TradeResult(boolean success, @org.jetbrains.annotations.NotNull
    java.lang.String message, long entryOrderId, long stopLossOrderId, long takeProfitOrderId) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean getSuccess() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long getEntryOrderId() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final long getStopLossOrderId() {
        return 0L;
    }
    
    public final long component5() {
        return 0L;
    }
    
    public final long getTakeProfitOrderId() {
        return 0L;
    }
}
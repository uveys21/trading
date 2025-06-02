package com.uveys.trader.presentation.viewmodel;

import java.lang.System;

/**
 * Ana ekran UI durumu
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b-\b\u0087\b\u0018\u00002\u00020\u0001B\u00b1\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u001bJ\t\u00100\u001a\u00020\u0003H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\t\u00102\u001a\u00020\u0013H\u00c6\u0003J\t\u00103\u001a\u00020\u0015H\u00c6\u0003J\t\u00104\u001a\u00020\u0005H\u00c6\u0003J\t\u00105\u001a\u00020\u0018H\u00c6\u0003J\t\u00106\u001a\u00020\u0018H\u00c6\u0003J\t\u00107\u001a\u00020\u0005H\u00c6\u0003J\t\u00108\u001a\u00020\u0005H\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\f0\tH\u00c6\u0003J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0003H\u00c6\u0003J\t\u0010?\u001a\u00020\u0010H\u00c6\u0003J\u00b5\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010A\u001a\u00020\u00032\b\u0010B\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010C\u001a\u00020\u0013H\u00d6\u0001J\t\u0010D\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010$R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010$R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010$R\u0011\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001fR\u0011\u0010\u001a\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001dR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001d\u00a8\u0006E"}, d2 = {"Lcom/uveys/trader/presentation/viewmodel/MainUiState;", "", "isLoading", "", "errorMessage", "", "balance", "selectedSymbol", "positions", "", "Lcom/uveys/trader/domain/entity/Position;", "orderHistory", "Lcom/uveys/trader/domain/entity/Order;", "isStrategyRunning", "isAutoTradeEnabled", "currentSignal", "Lcom/uveys/trader/domain/usecase/TradingSignal;", "lastTradeResult", "leverage", "", "riskPercentage", "", "connectionStatus", "connectionLatency", "", "lastSignalTime", "lastTradeDetails", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;ZZLcom/uveys/trader/domain/usecase/TradingSignal;Ljava/lang/String;IDLjava/lang/String;JJLjava/lang/String;)V", "getBalance", "()Ljava/lang/String;", "getConnectionLatency", "()J", "getConnectionStatus", "getCurrentSignal", "()Lcom/uveys/trader/domain/usecase/TradingSignal;", "getErrorMessage", "()Z", "getLastSignalTime", "getLastTradeDetails", "getLastTradeResult", "getLeverage", "()I", "getOrderHistory", "()Ljava/util/List;", "getPositions", "getRiskPercentage", "()D", "getSelectedSymbol", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class MainUiState {
    private final boolean isLoading = false;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String errorMessage = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String balance = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String selectedSymbol = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.uveys.trader.domain.entity.Position> positions = null;
    @org.jetbrains.annotations.NotNull
    private final java.util.List<com.uveys.trader.domain.entity.Order> orderHistory = null;
    private final boolean isStrategyRunning = false;
    private final boolean isAutoTradeEnabled = false;
    @org.jetbrains.annotations.NotNull
    private final com.uveys.trader.domain.usecase.TradingSignal currentSignal = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String lastTradeResult = null;
    private final int leverage = 0;
    private final double riskPercentage = 0.0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String connectionStatus = null;
    private final long connectionLatency = 0L;
    private final long lastSignalTime = 0L;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String lastTradeDetails = null;
    
    /**
     * Ana ekran UI durumu
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.presentation.viewmodel.MainUiState copy(boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, @org.jetbrains.annotations.NotNull
    java.lang.String balance, @org.jetbrains.annotations.NotNull
    java.lang.String selectedSymbol, @org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Position> positions, @org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Order> orderHistory, boolean isStrategyRunning, boolean isAutoTradeEnabled, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.usecase.TradingSignal currentSignal, @org.jetbrains.annotations.NotNull
    java.lang.String lastTradeResult, int leverage, double riskPercentage, @org.jetbrains.annotations.NotNull
    java.lang.String connectionStatus, long connectionLatency, long lastSignalTime, @org.jetbrains.annotations.NotNull
    java.lang.String lastTradeDetails) {
        return null;
    }
    
    /**
     * Ana ekran UI durumu
     */
    @java.lang.Override
    public boolean equals(@org.jetbrains.annotations.Nullable
    java.lang.Object other) {
        return false;
    }
    
    /**
     * Ana ekran UI durumu
     */
    @java.lang.Override
    public int hashCode() {
        return 0;
    }
    
    /**
     * Ana ekran UI durumu
     */
    @org.jetbrains.annotations.NotNull
    @java.lang.Override
    public java.lang.String toString() {
        return null;
    }
    
    public MainUiState() {
        super();
    }
    
    public MainUiState(boolean isLoading, @org.jetbrains.annotations.NotNull
    java.lang.String errorMessage, @org.jetbrains.annotations.NotNull
    java.lang.String balance, @org.jetbrains.annotations.NotNull
    java.lang.String selectedSymbol, @org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Position> positions, @org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Order> orderHistory, boolean isStrategyRunning, boolean isAutoTradeEnabled, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.usecase.TradingSignal currentSignal, @org.jetbrains.annotations.NotNull
    java.lang.String lastTradeResult, int leverage, double riskPercentage, @org.jetbrains.annotations.NotNull
    java.lang.String connectionStatus, long connectionLatency, long lastSignalTime, @org.jetbrains.annotations.NotNull
    java.lang.String lastTradeDetails) {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getBalance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSelectedSymbol() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uveys.trader.domain.entity.Position> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uveys.trader.domain.entity.Position> getPositions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uveys.trader.domain.entity.Order> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.uveys.trader.domain.entity.Order> getOrderHistory() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean isStrategyRunning() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean isAutoTradeEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.usecase.TradingSignal component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.usecase.TradingSignal getCurrentSignal() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastTradeResult() {
        return null;
    }
    
    public final int component11() {
        return 0;
    }
    
    public final int getLeverage() {
        return 0;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final double getRiskPercentage() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getConnectionStatus() {
        return null;
    }
    
    public final long component14() {
        return 0L;
    }
    
    public final long getConnectionLatency() {
        return 0L;
    }
    
    public final long component15() {
        return 0L;
    }
    
    public final long getLastSignalTime() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLastTradeDetails() {
        return null;
    }
}
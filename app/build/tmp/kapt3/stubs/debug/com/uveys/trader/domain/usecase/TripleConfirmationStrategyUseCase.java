package com.uveys.trader.domain.usecase;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\r2\u0006\u0010\t\u001a\u00020\nJ)\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\'\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00182\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\""}, d2 = {"Lcom/uveys/trader/domain/usecase/TripleConfirmationStrategyUseCase;", "", "binanceRepository", "Lcom/uveys/trader/domain/repository/BinanceRepository;", "calculateIndicatorsUseCase", "Lcom/uveys/trader/domain/usecase/CalculateIndicatorsUseCase;", "(Lcom/uveys/trader/domain/repository/BinanceRepository;Lcom/uveys/trader/domain/usecase/CalculateIndicatorsUseCase;)V", "analyzeStrategy", "Lcom/uveys/trader/domain/usecase/TradingSignal;", "symbol", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "analyzeStrategyStream", "Lkotlinx/coroutines/flow/Flow;", "executeTradeSignal", "Lcom/uveys/trader/domain/usecase/TradeResult;", "signal", "leverage", "", "(Ljava/lang/String;Lcom/uveys/trader/domain/usecase/TradingSignal;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAccountBalance", "Ljava/math/BigDecimal;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOpenPositions", "", "Lcom/uveys/trader/domain/entity/Position;", "getOrderHistory", "Lcom/uveys/trader/domain/entity/Order;", "limit", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "startAutoTrading", "targetPosition", "Lcom/uveys/trader/domain/entity/PositionSide;", "Companion", "app_debug"})
@javax.inject.Singleton
public final class TripleConfirmationStrategyUseCase {
    private final com.uveys.trader.domain.repository.BinanceRepository binanceRepository = null;
    private final com.uveys.trader.domain.usecase.CalculateIndicatorsUseCase calculateIndicatorsUseCase = null;
    @org.jetbrains.annotations.NotNull
    public static final com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase.Companion Companion = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DEFAULT_INTERVAL = "15m";
    public static final int DEFAULT_CANDLE_LIMIT = 300;
    public static final double STOP_LOSS_PERCENTAGE = 2.0;
    public static final double TAKE_PROFIT_PERCENTAGE = 4.0;
    public static final double MAX_RISK_PERCENTAGE = 1.0;
    
    @javax.inject.Inject
    public TripleConfirmationStrategyUseCase(@org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.repository.BinanceRepository binanceRepository, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.usecase.CalculateIndicatorsUseCase calculateIndicatorsUseCase) {
        super();
    }
    
    /**
     * Stratejiyi analiz eder ve sinyal üretir
     * @param symbol Kripto para çifti
     * @return Sinyal akışı (Long, Short veya Nötr)
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object analyzeStrategy(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.usecase.TradingSignal> continuation) {
        return null;
    }
    
    /**
     * Gerçek zamanlı strateji analizi yapar
     * @param symbol Kripto para çifti
     * @return Sinyal akışı
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.uveys.trader.domain.usecase.TradingSignal> analyzeStrategyStream(@org.jetbrains.annotations.NotNull
    java.lang.String symbol) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAccountBalance(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.math.BigDecimal> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOpenPositions(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Position>> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getOrderHistory(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, int limit, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.uveys.trader.domain.entity.Order>> continuation) {
        return null;
    }
    
    /**
     * Otomatik işlem açar
     * @param symbol Kripto para çifti
     * @param signal İşlem sinyali
     * @param leverage Kaldıraç oranı
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object executeTradeSignal(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.usecase.TradingSignal signal, int leverage, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.usecase.TradeResult> continuation) {
        return null;
    }
    
    /**
     * Tüm future işlem çiftlerini tarar, belirli pozisyon sinyalinde işlem açar.
     * Her işlem çifti için ayrı bir akış oluşturur ve bu akışları birleştirir.
     * @param targetPosition İşlem açılacak hedef pozisyon (LONG veya SHORT). Null ise tüm sinyallerde işlem açılır.
     * @return İşlem sonuçlarını içeren bir akış.
     */
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.uveys.trader.domain.usecase.TradeResult> startAutoTrading(@org.jetbrains.annotations.Nullable
    com.uveys.trader.domain.entity.PositionSide targetPosition) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/uveys/trader/domain/usecase/TripleConfirmationStrategyUseCase$Companion;", "", "()V", "DEFAULT_CANDLE_LIMIT", "", "DEFAULT_INTERVAL", "", "MAX_RISK_PERCENTAGE", "", "STOP_LOSS_PERCENTAGE", "TAKE_PROFIT_PERCENTAGE", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}
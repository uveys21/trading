package com.uveys.trader.domain.usecase;

import java.lang.System;

/**
 * Manuel işlem yapmak için kullanılan use case
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J1\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J9\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J9\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J;\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J!\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/uveys/trader/domain/usecase/ManualTradingUseCase;", "", "binanceRepository", "Lcom/uveys/trader/domain/repository/BinanceRepository;", "(Lcom/uveys/trader/domain/repository/BinanceRepository;)V", "createLimitOrder", "Lcom/uveys/trader/domain/entity/Order;", "symbol", "", "side", "Lcom/uveys/trader/domain/entity/OrderSide;", "positionSide", "Lcom/uveys/trader/domain/entity/PositionSide;", "price", "Ljava/math/BigDecimal;", "quantity", "(Ljava/lang/String;Lcom/uveys/trader/domain/entity/OrderSide;Lcom/uveys/trader/domain/entity/PositionSide;Ljava/math/BigDecimal;Ljava/math/BigDecimal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMarketOrder", "(Ljava/lang/String;Lcom/uveys/trader/domain/entity/OrderSide;Lcom/uveys/trader/domain/entity/PositionSide;Ljava/math/BigDecimal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createStopLossOrder", "stopPrice", "createTakeProfitOrder", "placeOrder", "setLeverage", "", "leverage", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ManualTradingUseCase {
    private final com.uveys.trader.domain.repository.BinanceRepository binanceRepository = null;
    
    @javax.inject.Inject
    public ManualTradingUseCase(@org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.repository.BinanceRepository binanceRepository) {
        super();
    }
    
    /**
     * Manuel market emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createMarketOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    /**
     * Manuel limit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Fiyat
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createLimitOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    /**
     * Manuel stop-loss emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param stopPrice Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createStopLossOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal stopPrice, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    /**
     * Manuel take-profit emri oluşturur
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Tetiklenme fiyatı
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createTakeProfitOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
    
    /**
     * Kaldıraç oranını ayarlar
     * @param symbol Kripto para çifti
     * @param leverage Kaldıraç oranı
     * @return İşlem başarılı mı
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object setLeverage(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, int leverage, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    /**
     * Manuel emir oluşturur. Price null ise market emri, değilse limit emir oluşturur.
     * @param symbol Kripto para çifti
     * @param side Emir yönü (BUY/SELL)
     * @param positionSide Pozisyon yönü (LONG/SHORT)
     * @param price Fiyat (null ise market emri)
     * @param quantity Miktar
     * @return Oluşturulan emir
     */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object placeOrder(@org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.OrderSide side, @org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.PositionSide positionSide, @org.jetbrains.annotations.Nullable
    java.math.BigDecimal price, @org.jetbrains.annotations.NotNull
    java.math.BigDecimal quantity, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.uveys.trader.domain.entity.Order> continuation) {
        return null;
    }
}
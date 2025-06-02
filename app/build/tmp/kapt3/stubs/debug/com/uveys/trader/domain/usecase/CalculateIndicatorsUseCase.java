package com.uveys.trader.domain.usecase;

import java.lang.System;

/**
 * Teknik göstergeleri hesaplayan use case
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J$\u0010\b\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b\u00a8\u0006\r"}, d2 = {"Lcom/uveys/trader/domain/usecase/CalculateIndicatorsUseCase;", "", "()V", "createBarSeries", "Lorg/ta4j/core/BarSeries;", "candles", "", "Lcom/uveys/trader/domain/entity/Candle;", "execute", "Lcom/uveys/trader/domain/entity/TechnicalIndicator;", "symbol", "", "interval", "app_debug"})
public final class CalculateIndicatorsUseCase {
    
    @javax.inject.Inject
    public CalculateIndicatorsUseCase() {
        super();
    }
    
    /**
     * Verilen mum verileri için teknik göstergeleri hesaplar
     * @param candles Mum verileri listesi
     * @param symbol Kripto para çifti
     * @param interval Zaman aralığı
     * @return Teknik gösterge sonuçları
     */
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.TechnicalIndicator execute(@org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Candle> candles, @org.jetbrains.annotations.NotNull
    java.lang.String symbol, @org.jetbrains.annotations.NotNull
    java.lang.String interval) {
        return null;
    }
    
    /**
     * Mum verilerinden Ta4j BarSeries oluşturur
     */
    private final org.ta4j.core.BarSeries createBarSeries(java.util.List<com.uveys.trader.domain.entity.Candle> candles) {
        return null;
    }
}
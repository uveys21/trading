package com.uveys.trader.data.mapper;

import java.lang.System;

/**
 * DTO'ları domain modellerine dönüştüren mapper sınıfı
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\f\u00a8\u0006\r"}, d2 = {"Lcom/uveys/trader/data/mapper/BinanceMapper;", "", "()V", "mapToCandle", "Lcom/uveys/trader/domain/entity/Candle;", "dto", "Lcom/uveys/trader/data/dto/CandleDto;", "mapToOrder", "Lcom/uveys/trader/domain/entity/Order;", "Lcom/uveys/trader/data/dto/OrderDto;", "mapToPosition", "Lcom/uveys/trader/domain/entity/Position;", "Lcom/uveys/trader/data/dto/PositionDto;", "app_debug"})
public final class BinanceMapper {
    
    public BinanceMapper() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.Candle mapToCandle(@org.jetbrains.annotations.NotNull
    com.uveys.trader.data.dto.CandleDto dto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.Position mapToPosition(@org.jetbrains.annotations.NotNull
    com.uveys.trader.data.dto.PositionDto dto) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final com.uveys.trader.domain.entity.Order mapToOrder(@org.jetbrains.annotations.NotNull
    com.uveys.trader.data.dto.OrderDto dto) {
        return null;
    }
}
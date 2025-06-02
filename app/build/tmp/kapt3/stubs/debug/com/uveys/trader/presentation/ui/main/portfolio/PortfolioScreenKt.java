package com.uveys.trader.presentation.ui.main.portfolio;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a\u0010\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0004H\u0007\u001a$\u0010\u0007\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0007\u001a\u0010\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\tH\u0007\u001a\u0016\u0010\f\u001a\u00020\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\u0007\u00a8\u0006\r"}, d2 = {"OrderHistoryTab", "", "orderHistory", "", "Lcom/uveys/trader/domain/entity/Order;", "OrderItem", "order", "PortfolioScreen", "positions", "Lcom/uveys/trader/domain/entity/Position;", "PositionItem", "position", "PositionsTab", "app_debug"})
public final class PortfolioScreenKt {
    
    /**
     * Portföy ekranı - Açık pozisyonlar ve işlem geçmişi
     */
    @androidx.compose.runtime.Composable
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    public static final void PortfolioScreen(@org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Position> positions, @org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Order> orderHistory) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PositionsTab(@org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Position> positions) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void PositionItem(@org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.Position position) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OrderHistoryTab(@org.jetbrains.annotations.NotNull
    java.util.List<com.uveys.trader.domain.entity.Order> orderHistory) {
    }
    
    @androidx.compose.runtime.Composable
    public static final void OrderItem(@org.jetbrains.annotations.NotNull
    com.uveys.trader.domain.entity.Order order) {
    }
}
package com.uveys.trader.presentation.ui.main;

import java.lang.System;

/**
 * Bottom Navigation için ekran tanımları
 */
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0004\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/uveys/trader/presentation/ui/main/Screen;", "", "route", "", "label", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/graphics/vector/ImageVector;)V", "getIcon", "()Landroidx/compose/ui/graphics/vector/ImageVector;", "getLabel", "()Ljava/lang/String;", "getRoute", "Home", "Portfolio", "Settings", "Trading", "Lcom/uveys/trader/presentation/ui/main/Screen$Home;", "Lcom/uveys/trader/presentation/ui/main/Screen$Portfolio;", "Lcom/uveys/trader/presentation/ui/main/Screen$Settings;", "Lcom/uveys/trader/presentation/ui/main/Screen$Trading;", "app_debug"})
public abstract class Screen {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String label = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.ui.graphics.vector.ImageVector icon = null;
    
    private Screen(java.lang.String route, java.lang.String label, androidx.compose.ui.graphics.vector.ImageVector icon) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getLabel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.compose.ui.graphics.vector.ImageVector getIcon() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/uveys/trader/presentation/ui/main/Screen$Home;", "Lcom/uveys/trader/presentation/ui/main/Screen;", "()V", "app_debug"})
    public static final class Home extends com.uveys.trader.presentation.ui.main.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.uveys.trader.presentation.ui.main.Screen.Home INSTANCE = null;
        
        private Home() {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/uveys/trader/presentation/ui/main/Screen$Trading;", "Lcom/uveys/trader/presentation/ui/main/Screen;", "()V", "app_debug"})
    public static final class Trading extends com.uveys.trader.presentation.ui.main.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.uveys.trader.presentation.ui.main.Screen.Trading INSTANCE = null;
        
        private Trading() {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/uveys/trader/presentation/ui/main/Screen$Portfolio;", "Lcom/uveys/trader/presentation/ui/main/Screen;", "()V", "app_debug"})
    public static final class Portfolio extends com.uveys.trader.presentation.ui.main.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.uveys.trader.presentation.ui.main.Screen.Portfolio INSTANCE = null;
        
        private Portfolio() {
            super(null, null, null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/uveys/trader/presentation/ui/main/Screen$Settings;", "Lcom/uveys/trader/presentation/ui/main/Screen;", "()V", "app_debug"})
    public static final class Settings extends com.uveys.trader.presentation.ui.main.Screen {
        @org.jetbrains.annotations.NotNull
        public static final com.uveys.trader.presentation.ui.main.Screen.Settings INSTANCE = null;
        
        private Settings() {
            super(null, null, null);
        }
    }
}
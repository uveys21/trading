package com.uveys.trader.di;

import com.uveys.trader.data.api.websocket.BinanceWebSocketManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class AppModule_ProvideBinanceWebSocketManagerFactory implements Factory<BinanceWebSocketManager> {
  @Override
  public BinanceWebSocketManager get() {
    return provideBinanceWebSocketManager();
  }

  public static AppModule_ProvideBinanceWebSocketManagerFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BinanceWebSocketManager provideBinanceWebSocketManager() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBinanceWebSocketManager());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideBinanceWebSocketManagerFactory INSTANCE = new AppModule_ProvideBinanceWebSocketManagerFactory();
  }
}

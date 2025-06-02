package com.uveys.trader.data.api.websocket;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class BinanceWebSocketManager_Factory implements Factory<BinanceWebSocketManager> {
  @Override
  public BinanceWebSocketManager get() {
    return newInstance();
  }

  public static BinanceWebSocketManager_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BinanceWebSocketManager newInstance() {
    return new BinanceWebSocketManager();
  }

  private static final class InstanceHolder {
    private static final BinanceWebSocketManager_Factory INSTANCE = new BinanceWebSocketManager_Factory();
  }
}

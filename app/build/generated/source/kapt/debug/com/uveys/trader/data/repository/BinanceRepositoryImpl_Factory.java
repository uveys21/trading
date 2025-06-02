package com.uveys.trader.data.repository;

import com.uveys.trader.data.api.rest.BinanceApiService;
import com.uveys.trader.data.api.websocket.BinanceWebSocketManager;
import com.uveys.trader.data.mapper.BinanceMapper;
import com.uveys.trader.util.security.SecurePreferencesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class BinanceRepositoryImpl_Factory implements Factory<BinanceRepositoryImpl> {
  private final Provider<BinanceApiService> apiServiceProvider;

  private final Provider<BinanceWebSocketManager> webSocketManagerProvider;

  private final Provider<BinanceMapper> mapperProvider;

  private final Provider<SecurePreferencesManager> securePreferencesManagerProvider;

  public BinanceRepositoryImpl_Factory(Provider<BinanceApiService> apiServiceProvider,
      Provider<BinanceWebSocketManager> webSocketManagerProvider,
      Provider<BinanceMapper> mapperProvider,
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.webSocketManagerProvider = webSocketManagerProvider;
    this.mapperProvider = mapperProvider;
    this.securePreferencesManagerProvider = securePreferencesManagerProvider;
  }

  @Override
  public BinanceRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), webSocketManagerProvider.get(), mapperProvider.get(), securePreferencesManagerProvider.get());
  }

  public static BinanceRepositoryImpl_Factory create(Provider<BinanceApiService> apiServiceProvider,
      Provider<BinanceWebSocketManager> webSocketManagerProvider,
      Provider<BinanceMapper> mapperProvider,
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    return new BinanceRepositoryImpl_Factory(apiServiceProvider, webSocketManagerProvider, mapperProvider, securePreferencesManagerProvider);
  }

  public static BinanceRepositoryImpl newInstance(BinanceApiService apiService,
      BinanceWebSocketManager webSocketManager, BinanceMapper mapper,
      SecurePreferencesManager securePreferencesManager) {
    return new BinanceRepositoryImpl(apiService, webSocketManager, mapper, securePreferencesManager);
  }
}

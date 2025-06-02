package com.uveys.trader.di;

import com.uveys.trader.data.api.rest.BinanceApiService;
import com.uveys.trader.data.api.websocket.BinanceWebSocketManager;
import com.uveys.trader.data.mapper.BinanceMapper;
import com.uveys.trader.domain.repository.BinanceRepository;
import com.uveys.trader.util.security.SecurePreferencesManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideBinanceRepositoryFactory implements Factory<BinanceRepository> {
  private final Provider<BinanceApiService> apiServiceProvider;

  private final Provider<BinanceWebSocketManager> webSocketManagerProvider;

  private final Provider<BinanceMapper> mapperProvider;

  private final Provider<SecurePreferencesManager> securePreferencesManagerProvider;

  public AppModule_ProvideBinanceRepositoryFactory(Provider<BinanceApiService> apiServiceProvider,
      Provider<BinanceWebSocketManager> webSocketManagerProvider,
      Provider<BinanceMapper> mapperProvider,
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.webSocketManagerProvider = webSocketManagerProvider;
    this.mapperProvider = mapperProvider;
    this.securePreferencesManagerProvider = securePreferencesManagerProvider;
  }

  @Override
  public BinanceRepository get() {
    return provideBinanceRepository(apiServiceProvider.get(), webSocketManagerProvider.get(), mapperProvider.get(), securePreferencesManagerProvider.get());
  }

  public static AppModule_ProvideBinanceRepositoryFactory create(
      Provider<BinanceApiService> apiServiceProvider,
      Provider<BinanceWebSocketManager> webSocketManagerProvider,
      Provider<BinanceMapper> mapperProvider,
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    return new AppModule_ProvideBinanceRepositoryFactory(apiServiceProvider, webSocketManagerProvider, mapperProvider, securePreferencesManagerProvider);
  }

  public static BinanceRepository provideBinanceRepository(BinanceApiService apiService,
      BinanceWebSocketManager webSocketManager, BinanceMapper mapper,
      SecurePreferencesManager securePreferencesManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBinanceRepository(apiService, webSocketManager, mapper, securePreferencesManager));
  }
}

package com.uveys.trader.di;

import com.uveys.trader.util.security.BinanceAuthInterceptor;
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
public final class AppModule_ProvideBinanceAuthInterceptorFactory implements Factory<BinanceAuthInterceptor> {
  private final Provider<SecurePreferencesManager> securePreferencesManagerProvider;

  public AppModule_ProvideBinanceAuthInterceptorFactory(
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    this.securePreferencesManagerProvider = securePreferencesManagerProvider;
  }

  @Override
  public BinanceAuthInterceptor get() {
    return provideBinanceAuthInterceptor(securePreferencesManagerProvider.get());
  }

  public static AppModule_ProvideBinanceAuthInterceptorFactory create(
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    return new AppModule_ProvideBinanceAuthInterceptorFactory(securePreferencesManagerProvider);
  }

  public static BinanceAuthInterceptor provideBinanceAuthInterceptor(
      SecurePreferencesManager securePreferencesManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBinanceAuthInterceptor(securePreferencesManager));
  }
}

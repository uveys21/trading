package com.uveys.trader.util.security;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class BinanceAuthInterceptor_Factory implements Factory<BinanceAuthInterceptor> {
  private final Provider<SecurePreferencesManager> securePreferencesManagerProvider;

  public BinanceAuthInterceptor_Factory(
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    this.securePreferencesManagerProvider = securePreferencesManagerProvider;
  }

  @Override
  public BinanceAuthInterceptor get() {
    return newInstance(securePreferencesManagerProvider.get());
  }

  public static BinanceAuthInterceptor_Factory create(
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    return new BinanceAuthInterceptor_Factory(securePreferencesManagerProvider);
  }

  public static BinanceAuthInterceptor newInstance(
      SecurePreferencesManager securePreferencesManager) {
    return new BinanceAuthInterceptor(securePreferencesManager);
  }
}

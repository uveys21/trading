package com.uveys.trader.di;

import com.uveys.trader.util.security.BinanceAuthInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class AppModule_ProvideOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<BinanceAuthInterceptor> binanceAuthInterceptorProvider;

  public AppModule_ProvideOkHttpClientFactory(
      Provider<BinanceAuthInterceptor> binanceAuthInterceptorProvider) {
    this.binanceAuthInterceptorProvider = binanceAuthInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttpClient(binanceAuthInterceptorProvider.get());
  }

  public static AppModule_ProvideOkHttpClientFactory create(
      Provider<BinanceAuthInterceptor> binanceAuthInterceptorProvider) {
    return new AppModule_ProvideOkHttpClientFactory(binanceAuthInterceptorProvider);
  }

  public static OkHttpClient provideOkHttpClient(BinanceAuthInterceptor binanceAuthInterceptor) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideOkHttpClient(binanceAuthInterceptor));
  }
}

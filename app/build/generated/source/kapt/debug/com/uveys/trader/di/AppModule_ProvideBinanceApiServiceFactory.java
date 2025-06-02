package com.uveys.trader.di;

import com.uveys.trader.data.api.rest.BinanceApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AppModule_ProvideBinanceApiServiceFactory implements Factory<BinanceApiService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideBinanceApiServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public BinanceApiService get() {
    return provideBinanceApiService(retrofitProvider.get());
  }

  public static AppModule_ProvideBinanceApiServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideBinanceApiServiceFactory(retrofitProvider);
  }

  public static BinanceApiService provideBinanceApiService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBinanceApiService(retrofit));
  }
}

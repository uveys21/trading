package com.uveys.trader.di;

import com.uveys.trader.data.mapper.BinanceMapper;
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
public final class AppModule_ProvideBinanceMapperFactory implements Factory<BinanceMapper> {
  @Override
  public BinanceMapper get() {
    return provideBinanceMapper();
  }

  public static AppModule_ProvideBinanceMapperFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BinanceMapper provideBinanceMapper() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideBinanceMapper());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideBinanceMapperFactory INSTANCE = new AppModule_ProvideBinanceMapperFactory();
  }
}

package com.uveys.trader.domain.usecase;

import com.uveys.trader.domain.repository.BinanceRepository;
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
public final class ManualTradingUseCase_Factory implements Factory<ManualTradingUseCase> {
  private final Provider<BinanceRepository> binanceRepositoryProvider;

  public ManualTradingUseCase_Factory(Provider<BinanceRepository> binanceRepositoryProvider) {
    this.binanceRepositoryProvider = binanceRepositoryProvider;
  }

  @Override
  public ManualTradingUseCase get() {
    return newInstance(binanceRepositoryProvider.get());
  }

  public static ManualTradingUseCase_Factory create(
      Provider<BinanceRepository> binanceRepositoryProvider) {
    return new ManualTradingUseCase_Factory(binanceRepositoryProvider);
  }

  public static ManualTradingUseCase newInstance(BinanceRepository binanceRepository) {
    return new ManualTradingUseCase(binanceRepository);
  }
}

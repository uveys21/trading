package com.uveys.trader.domain.usecase;

import com.uveys.trader.domain.repository.BinanceRepository;
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
public final class TripleConfirmationStrategyUseCase_Factory implements Factory<TripleConfirmationStrategyUseCase> {
  private final Provider<BinanceRepository> binanceRepositoryProvider;

  private final Provider<CalculateIndicatorsUseCase> calculateIndicatorsUseCaseProvider;

  public TripleConfirmationStrategyUseCase_Factory(
      Provider<BinanceRepository> binanceRepositoryProvider,
      Provider<CalculateIndicatorsUseCase> calculateIndicatorsUseCaseProvider) {
    this.binanceRepositoryProvider = binanceRepositoryProvider;
    this.calculateIndicatorsUseCaseProvider = calculateIndicatorsUseCaseProvider;
  }

  @Override
  public TripleConfirmationStrategyUseCase get() {
    return newInstance(binanceRepositoryProvider.get(), calculateIndicatorsUseCaseProvider.get());
  }

  public static TripleConfirmationStrategyUseCase_Factory create(
      Provider<BinanceRepository> binanceRepositoryProvider,
      Provider<CalculateIndicatorsUseCase> calculateIndicatorsUseCaseProvider) {
    return new TripleConfirmationStrategyUseCase_Factory(binanceRepositoryProvider, calculateIndicatorsUseCaseProvider);
  }

  public static TripleConfirmationStrategyUseCase newInstance(BinanceRepository binanceRepository,
      CalculateIndicatorsUseCase calculateIndicatorsUseCase) {
    return new TripleConfirmationStrategyUseCase(binanceRepository, calculateIndicatorsUseCase);
  }
}

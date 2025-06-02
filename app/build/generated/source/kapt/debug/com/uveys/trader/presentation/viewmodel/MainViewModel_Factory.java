package com.uveys.trader.presentation.viewmodel;

import com.uveys.trader.domain.repository.BinanceRepository;
import com.uveys.trader.domain.usecase.ManualTradingUseCase;
import com.uveys.trader.domain.usecase.TripleConfirmationStrategyUseCase;
import com.uveys.trader.util.security.SecurePreferencesManager;
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
public final class MainViewModel_Factory implements Factory<MainViewModel> {
  private final Provider<ManualTradingUseCase> manualTradingUseCaseProvider;

  private final Provider<TripleConfirmationStrategyUseCase> strategyUseCaseProvider;

  private final Provider<BinanceRepository> binanceRepositoryProvider;

  private final Provider<SecurePreferencesManager> securePreferencesManagerProvider;

  public MainViewModel_Factory(Provider<ManualTradingUseCase> manualTradingUseCaseProvider,
      Provider<TripleConfirmationStrategyUseCase> strategyUseCaseProvider,
      Provider<BinanceRepository> binanceRepositoryProvider,
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    this.manualTradingUseCaseProvider = manualTradingUseCaseProvider;
    this.strategyUseCaseProvider = strategyUseCaseProvider;
    this.binanceRepositoryProvider = binanceRepositoryProvider;
    this.securePreferencesManagerProvider = securePreferencesManagerProvider;
  }

  @Override
  public MainViewModel get() {
    return newInstance(manualTradingUseCaseProvider.get(), strategyUseCaseProvider.get(), binanceRepositoryProvider.get(), securePreferencesManagerProvider.get());
  }

  public static MainViewModel_Factory create(
      Provider<ManualTradingUseCase> manualTradingUseCaseProvider,
      Provider<TripleConfirmationStrategyUseCase> strategyUseCaseProvider,
      Provider<BinanceRepository> binanceRepositoryProvider,
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    return new MainViewModel_Factory(manualTradingUseCaseProvider, strategyUseCaseProvider, binanceRepositoryProvider, securePreferencesManagerProvider);
  }

  public static MainViewModel newInstance(ManualTradingUseCase manualTradingUseCase,
      TripleConfirmationStrategyUseCase strategyUseCase, BinanceRepository binanceRepository,
      SecurePreferencesManager securePreferencesManager) {
    return new MainViewModel(manualTradingUseCase, strategyUseCase, binanceRepository, securePreferencesManager);
  }
}

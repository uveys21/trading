package com.uveys.trader.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class CalculateIndicatorsUseCase_Factory implements Factory<CalculateIndicatorsUseCase> {
  @Override
  public CalculateIndicatorsUseCase get() {
    return newInstance();
  }

  public static CalculateIndicatorsUseCase_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CalculateIndicatorsUseCase newInstance() {
    return new CalculateIndicatorsUseCase();
  }

  private static final class InstanceHolder {
    private static final CalculateIndicatorsUseCase_Factory INSTANCE = new CalculateIndicatorsUseCase_Factory();
  }
}

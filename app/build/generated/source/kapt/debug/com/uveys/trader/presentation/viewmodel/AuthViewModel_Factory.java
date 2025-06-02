package com.uveys.trader.presentation.viewmodel;

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
public final class AuthViewModel_Factory implements Factory<AuthViewModel> {
  private final Provider<SecurePreferencesManager> securePreferencesManagerProvider;

  public AuthViewModel_Factory(
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    this.securePreferencesManagerProvider = securePreferencesManagerProvider;
  }

  @Override
  public AuthViewModel get() {
    return newInstance(securePreferencesManagerProvider.get());
  }

  public static AuthViewModel_Factory create(
      Provider<SecurePreferencesManager> securePreferencesManagerProvider) {
    return new AuthViewModel_Factory(securePreferencesManagerProvider);
  }

  public static AuthViewModel newInstance(SecurePreferencesManager securePreferencesManager) {
    return new AuthViewModel(securePreferencesManager);
  }
}

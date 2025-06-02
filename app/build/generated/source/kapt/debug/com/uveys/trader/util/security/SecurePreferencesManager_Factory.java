package com.uveys.trader.util.security;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class SecurePreferencesManager_Factory implements Factory<SecurePreferencesManager> {
  private final Provider<Context> contextProvider;

  public SecurePreferencesManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SecurePreferencesManager get() {
    return newInstance(contextProvider.get());
  }

  public static SecurePreferencesManager_Factory create(Provider<Context> contextProvider) {
    return new SecurePreferencesManager_Factory(contextProvider);
  }

  public static SecurePreferencesManager newInstance(Context context) {
    return new SecurePreferencesManager(context);
  }
}

package com.uveys.trader.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.uveys.trader.data.api.rest.BinanceApiService
import com.uveys.trader.data.api.websocket.BinanceWebSocketManager
import com.uveys.trader.data.mapper.BinanceMapper
import com.uveys.trader.data.repository.BinanceRepositoryImpl
import com.uveys.trader.domain.repository.BinanceRepository
import com.uveys.trader.util.security.BinanceAuthInterceptor
import com.uveys.trader.util.security.SecurePreferencesManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSecurePreferencesManager(@ApplicationContext context: Context): SecurePreferencesManager {
        return SecurePreferencesManager(context)
    }

    @Provides
    @Singleton
    fun provideBinanceAuthInterceptor(securePreferencesManager: SecurePreferencesManager): BinanceAuthInterceptor {
        return BinanceAuthInterceptor(securePreferencesManager)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(binanceAuthInterceptor: BinanceAuthInterceptor): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(binanceAuthInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://fapi.binance.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideBinanceApiService(retrofit: Retrofit): BinanceApiService {
        return retrofit.create(BinanceApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideBinanceWebSocketManager(): BinanceWebSocketManager {
        return BinanceWebSocketManager()
    }

    @Provides
    @Singleton
    fun provideBinanceMapper(): BinanceMapper {
        return BinanceMapper()
    }

    @Provides
    @Singleton
    fun provideBinanceRepository(
        apiService: BinanceApiService,
        webSocketManager: BinanceWebSocketManager,
        mapper: BinanceMapper,
        securePreferencesManager: SecurePreferencesManager
    ): BinanceRepository {
        return BinanceRepositoryImpl(apiService, webSocketManager, mapper, securePreferencesManager)
    }
}

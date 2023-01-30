package com.example.daggerhiltpractice.di

import android.app.Application
import com.example.daggerhiltpractice.model.remote.api.ApiService
import com.example.daggerhiltpractice.model.remote.repository.NetworkRepository
import com.example.daggerhiltpractice.model.remote.repository.NetworkRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiClientModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = "https://rickandmortyapi.com/api/"

    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


    @Provides
    @Singleton
    fun provideApiService(
        baseUrl: String,
        moshi: Moshi
    ): ApiService {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNetworkRepository(
        api: ApiService,
        appContext: Application
    ): NetworkRepository {
        return NetworkRepositoryImpl(api, appContext)
    }

}
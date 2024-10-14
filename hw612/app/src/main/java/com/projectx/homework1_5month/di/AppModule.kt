package com.projectx.homework1_5month.di

import com.projectx.homework1_5month.BuildConfig
import com.projectx.homework1_5month.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL).addConverterFactory(GsonConverterFactory.create())
            .build()

    }
    @Provides
    fun provideApi(retrofit: Retrofit): ApiService {
        return  retrofit.create(ApiService::class.java)

    }

}
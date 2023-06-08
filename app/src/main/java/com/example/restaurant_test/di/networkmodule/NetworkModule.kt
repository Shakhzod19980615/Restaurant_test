package com.example.restaurant_test.di.networkmodule

import com.example.restaurant_test.data.ApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module(includes = [NetworkModule.Providers::class])
interface NetworkModule {

    @Module
    object Providers{
        @OptIn(ExperimentalSerializationApi::class)
        @Singleton
        @Provides
        fun provideRetrofit(): Retrofit {
            val json = Json {
                ignoreUnknownKeys = true
                isLenient = true

            }
            return Retrofit.Builder()
                .baseUrl("https://run.mocky.io/v3")
                .client(provideOkhttp())
                .addConverterFactory(json.asConverterFactory(MediaType.parse("application/json")!!))
                .build()
        }

            @Singleton
            @Provides
            fun provideApi(retrofit: Retrofit): ApiService {
                return retrofit.create(ApiService::class.java)
            }

            @Singleton
            @Provides
            fun provideOkhttp(): OkHttpClient {
                val okHttpClient = OkHttpClient.Builder()
                okHttpClient.writeTimeout(5, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES)
                return okHttpClient.build()

            }
    }
}
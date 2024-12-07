package com.example.weatherapp.di

import com.example.weatherapp.data.api.WeatherApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Makes this module available throughout the app lifecycle
object NetworkModule {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/" // Replace with your API base URL

    // Provide a Retrofit instance
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()) // Use Gson to convert JSON to Kotlin objects
            .build()
    }

    // Provide WeatherApi instance
    @Provides
    @Singleton
    fun provideWeatherApi(retrofit: Retrofit): WeatherApi {
        return retrofit.create(WeatherApi::class.java)
    }
}

package com.example.weatherapp.di

import com.example.weatherapp.data.repository.WeatherRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.Provides
import dagger.hilt.components.SingletonComponent

// Hilt Module to provide app-level dependencies
@Module
@InstallIn(SingletonComponent::class) // Install the module in the SingletonComponent
object AppModule {
    @Provides
    fun provideWeatherRepository(): WeatherRepository {
        return WeatherRepository() // Provide an instance of WeatherRepository
    }
}

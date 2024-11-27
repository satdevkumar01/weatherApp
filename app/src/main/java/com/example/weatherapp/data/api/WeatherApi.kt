package com.example.weatherapp.data.api

import com.example.weatherapp.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

// API Service using Retrofit for network requests
interface WeatherApi {
    // Endpoint to get current weather data for a city
    @GET("weather")
    suspend fun getCurrentWeather(
        @Query("q") city: String,              // City name
        @Query("appid") apiKey: String,       // API key for OpenWeatherMap
        @Query("units") units: String = "metric" // Units (metric for Celsius)
    ): WeatherResponse
}

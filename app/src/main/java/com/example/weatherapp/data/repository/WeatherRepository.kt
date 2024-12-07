package com.example.weatherapp.data.repository

import com.example.weatherapp.data.api.RetrofitInstance
import com.example.weatherapp.data.api.WeatherApi
import com.example.weatherapp.data.model.WeatherResponse
import javax.inject.Inject

// Repository to handle API calls and data management
open class WeatherRepository @Inject constructor(
    private val api: WeatherApi
){
// Function to fetch weather data for a specific city
    suspend fun getWeather(city: String, apiKey: String): WeatherResponse {
        return api.getCurrentWeather(city, apiKey) // Call the API and return the response
    }
}


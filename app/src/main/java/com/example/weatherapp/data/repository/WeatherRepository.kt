package com.example.weatherapp.data.repository

import com.example.weatherapp.data.api.RetrofitInstance
import com.example.weatherapp.data.model.WeatherResponse

// Repository to handle API calls and data management
class WeatherRepository {
    private val api = RetrofitInstance.api // Get the API instance

    // Function to fetch weather data for a specific city
    suspend fun getWeather(city: String, apiKey: String): WeatherResponse {
        return api.getCurrentWeather(city, apiKey) // Call the API and return the response
    }
}
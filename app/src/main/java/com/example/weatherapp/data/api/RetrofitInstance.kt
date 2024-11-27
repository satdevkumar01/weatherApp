package com.example.weatherapp.data.api
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Singleton object to provide Retrofit instance
object RetrofitInstance {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/" // Base URL for the API

    val api: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)                            // Set the API's base URL
            .addConverterFactory(GsonConverterFactory.create()) // Add Gson converter for JSON
            .build()
            .create(WeatherApi::class.java)              // Create the WeatherApi service
    }
}
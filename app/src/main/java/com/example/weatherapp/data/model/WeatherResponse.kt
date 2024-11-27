package com.example.weatherapp.data.model

// Data class for the overall weather response
data class WeatherResponse(
    val name: String,                  // City name
    val main: Main,                    // Main weather info (temp, humidity, etc.)
    val weather: List<Weather>         // List of weather details (e.g., description)
)

// Data class for main weather details
data class Main(
    val temp: Double,                  // Current temperature
    val humidity: Int                  // Humidity percentage
)

// Data class for specific weather details
data class Weather(
    val description: String,           // Weather description (e.g., clear sky)
    val icon: String                   // Weather icon ID
)

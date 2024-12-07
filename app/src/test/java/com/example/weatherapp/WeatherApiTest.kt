package com.example.weatherapp

import com.example.weatherapp.data.api.WeatherApi
import com.example.weatherapp.data.model.Main
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.model.WeatherResponse
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.*
import org.junit.Assert.assertEquals

class WeatherApiTest{

    @Test
    fun `getCurrentWeather should call the correct endpoint with parameters`(): Unit = runBlocking {
        val api = mock(WeatherApi::class.java) 
        val city = "London"
        val apiKey = "106af51f502e4cbbd21491fb8f1a0571"

        api.getCurrentWeather(city, apiKey)

        verify(api).getCurrentWeather(city, apiKey, "metric")
    }

    // Additional test: Verify successful response parsing (using a mock response)
    @Test
    fun `getCurrentWeather should parse the response correctly`() = runBlocking {
        val api = mock(WeatherApi::class.java)
        val city = "London"
        val apiKey = "106af51f502e4cbbd21491fb8f1a0571"
        val mockResponse = WeatherResponse( // Create a mock WeatherResponse
            name = "London", 
            main = Main(temp = 15.0, humidity = 60),
            weather = listOf(Weather(description = "Cloudy", icon = "04d"))
        )

        `when`(api.getCurrentWeather(city, apiKey)).thenReturn(mockResponse)

        val response = api.getCurrentWeather(city, apiKey)
        assertEquals("London", response.name)
        // ... add more assertions to check other properties
    }
}
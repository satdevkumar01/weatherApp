package com.example.weatherapp

import com.example.weatherapp.data.api.WeatherApi
import com.example.weatherapp.data.model.Main
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.repository.WeatherRepository
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.junit.Assert.assertEquals

@RunWith(MockitoJUnitRunner::class)
class WeatherRepositoryTest {

    @Mock
    private lateinit var api: WeatherApi // Mock dependency

    private lateinit var repository: WeatherRepository

    @Before
    fun setup() {
        // Pass the mocked API to the repository constructor
        repository = WeatherRepository(api)
    }

    @Test
    fun `fetch weather successfully`() = runTest {
        // Arrange
        Mockito.`when`(api.getCurrentWeather("New York", "fake_api_key")).thenReturn(
            WeatherResponse(
                name = "New York",
                main = Main(temp = 20.0, humidity = 65),
                weather = listOf(Weather(description = "Clear", icon = "01d"))
            )
        )

        // Act
        val result = repository.getWeather("New York", "fake_api_key")

        // Assert
        assertEquals("New York", result.name)
        assertEquals(20.0, result.main.temp, 0.0)
        assertEquals("Clear", result.weather[0].description)
    }

    @Test(expected = Exception::class)
    fun `fetch weather with error`() = runTest {
        // Arrange
        Mockito.`when`(api.getCurrentWeather("InvalidCity", "fake_api_key")).thenThrow(Exception("City not found"))

        // Act
        repository.getWeather("InvalidCity", "fake_api_key")
    }
}








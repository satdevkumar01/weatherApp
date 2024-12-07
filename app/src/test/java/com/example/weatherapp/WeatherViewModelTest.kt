package com.example.weatherapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.weatherapp.data.model.Main
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.ui.viewmodels.WeatherViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@ExperimentalCoroutinesApi
class WeatherViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val testDispatcher = StandardTestDispatcher()

    private val repository = mock(WeatherRepository::class.java)
    private lateinit var viewModel: WeatherViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        viewModel = WeatherViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchWeather data`() = runTest {
        val city = "Tokyo"
        val apiKey = "106af51f502e4cbbd21491fb8f1a0571"

        val mockResponse = WeatherResponse(
            name = "Tokyo",
            main = Main(temp = 22.0, humidity = 65),
            weather = listOf(Weather(description = "Rainy", icon = "10d"))
        )

        `when`(repository.getWeather(city, apiKey)).thenReturn(mockResponse)

        viewModel.fetchWeather(city, apiKey)

        advanceUntilIdle()

        assertEquals(mockResponse, viewModel.weather.value)
    }
    /*
        // Test for error handling in the ViewModel
        @Test
        fun `fetchWeather should handle exceptions from repository`() = runTest{
            val city = "Tokyo"
            val apiKey = "106af51f502e4cbbd21491fb8f1a0571"
            `when`(repository.getWeather(city, apiKey)).thenThrow(RuntimeException("Network Error"))

            viewModel.fetchWeather(city, apiKey)

            // Add assertions to check for error states or messages if you have any in your ViewModel
        }*/
}
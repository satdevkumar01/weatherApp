package com.example.weatherapp

import com.example.weatherapp.data.api.RetrofitInstance
import com.example.weatherapp.data.api.WeatherApi
import org.junit.Test
import org.junit.Assert.*

class RetrofitInstanceTest {

    @Test
    fun `api property should return a WeatherApi instance`() {
        val api = RetrofitInstance.api
        assertNotNull(api)
        assertTrue(api is WeatherApi)
    }
}
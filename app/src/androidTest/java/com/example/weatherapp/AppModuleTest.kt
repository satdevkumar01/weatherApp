package com.example.weatherapp

import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.di.AppModule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(AppModule::class) // Uninstall the actual AppModule
class AppModuleTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repository: WeatherRepository

    @Before
    fun init() {
        hiltRule.inject() 
    }

    @Test
    fun appModuleTests() {
        assertNotNull(repository) 
        assertTrue(repository is WeatherRepository)
    }
}
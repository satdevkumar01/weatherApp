package com.example.weatherapp.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.weatherapp.ui.viewmodels.WeatherViewModel

// Composable function to display the weather screen
@Composable
fun WeatherScreen(viewModel: WeatherViewModel = hiltViewModel()) {
    val weather = viewModel.weather.observeAsState() // Observe LiveData for updates

    // Layout for the weather screen
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        weather.value?.let { data ->
            // Display weather data

            Text(text = "City: ${data.name}", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Temperature: ${data.main.temp}°C", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Humidity: ${data.main.humidity}%", fontSize = 20.sp)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description: ${data.weather[0].description}", fontSize = 18.sp)
        } ?: run {
            viewModel.fetchWeather("Abohar","106af51f502e4cbbd21491fb8f1a0571")
            // Show loading message
            Text("Loading weather data...", fontSize = 18.sp)
        }
    }
}

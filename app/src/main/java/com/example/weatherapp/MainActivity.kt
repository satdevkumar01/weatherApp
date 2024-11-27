package com.example.weatherapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.weatherapp.ui.view.WeatherScreen
import dagger.hilt.android.AndroidEntryPoint

// Main activity for the app
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Set up the WeatherScreen Composable
            WeatherScreen()
        }
    }
}

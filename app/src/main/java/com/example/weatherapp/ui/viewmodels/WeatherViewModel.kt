package com.example.weatherapp.ui.viewmodels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.data.model.WeatherResponse
import com.example.weatherapp.data.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

// ViewModel to manage weather data and interact with the repository
@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val repository: WeatherRepository // Inject repository
) : ViewModel() {

    // LiveData to store weather response
    private val _weather = MutableLiveData<WeatherResponse>()
    val weather: LiveData<WeatherResponse> get() = _weather

    // Function to fetch weather data and update LiveData
    fun fetchWeather(city: String, apiKey: String) {
        viewModelScope.launch { // Launch coroutine in the ViewModel's scope
            try {
                val response = repository.getWeather(city, apiKey) // Fetch data from repository
                _weather.postValue(response) // Post value to LiveData
            } catch (e: Exception) {
                // Handle errors (e.g., network failure)
                print("Error fetching weather data  : $e")
                e.printStackTrace()
            }
        }
    }
}

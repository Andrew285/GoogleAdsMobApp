package com.example.taskforapptech.retrofit

import com.example.taskforapptech.model.results.WeatherResult
import retrofit2.Call
import retrofit2.http.GET

interface WeatherApiService {
    @GET("weather/Lviv")
    fun getWeatherData(): Call<WeatherResult?>?
}


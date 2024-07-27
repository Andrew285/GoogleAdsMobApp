package com.example.taskforapptech.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskforapptech.model.Weather
import com.example.taskforapptech.model.results.WeatherResult
import com.example.taskforapptech.retrofit.RetrofitInstance
import com.example.taskforapptech.retrofit.WeatherApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WeatherRepository() {
    private var weatherData: ArrayList<Weather> = ArrayList()
    private val mutableLiveData: MutableLiveData<List<Weather>> = MutableLiveData<List<Weather>>()

    fun getMutableLiveData(): LiveData<List<Weather>> {
        val weatherApiService: WeatherApiService = RetrofitInstance.weatherApiService
        val call: Call<WeatherResult?>? =
            weatherApiService.getWeatherData()
        call?.enqueue(object : Callback<WeatherResult?> {
            override fun onResponse(call: Call<WeatherResult?>, response: Response<WeatherResult?>) {
                val result: WeatherResult? = response.body()
                if (result?.getForecast() != null) {
                    weatherData = result.getForecast() as ArrayList<Weather>
                    mutableLiveData.value = weatherData
                }
            }

            override fun onFailure(call: Call<WeatherResult?>, t: Throwable) {}
        })
        return mutableLiveData
    }
}

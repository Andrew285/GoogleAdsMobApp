package com.example.taskforapptech.model.results

import com.example.taskforapptech.model.Weather
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class WeatherResult {
    @SerializedName("temperature")
    @Expose
    private var temperature: String? = null

    @SerializedName("wind")
    @Expose
    private var wind: String? = null

    @SerializedName("description")
    @Expose
    private var description: String? = null

    @SerializedName("forecast")
    @Expose
    private var forecast: List<Weather?>? = null

    fun getTemperature(): String? {
        return temperature
    }

    fun setTemperature(temperature: String?) {
        this.temperature = temperature
    }

    fun getWind(): String? {
        return wind
    }

    fun setWind(wind: String?) {
        this.wind = wind
    }

    fun getDescription(): String? {
        return description
    }

    fun setDescription(description: String?) {
        this.description = description
    }

    fun getForecast(): List<Weather?>? {
        return forecast
    }

    fun setForecast(forecast: List<Weather?>?) {
        this.forecast = forecast
    }
}
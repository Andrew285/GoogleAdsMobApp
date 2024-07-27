package com.example.taskforapptech.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

class Weather {
    @SerializedName("day")
    @Expose
    private var day: String? = null

    @SerializedName("temperature")
    @Expose
    private var temperature: String? = null

    @SerializedName("wind")
    @Expose
    private var wind: String? = null

    fun getDay(): String? {
        return day
    }

    fun setDay(day: String?) {
        this.day = day
    }

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

}
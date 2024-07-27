package com.example.taskforapptech.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class CatBreed {
    @SerializedName("breed")
    @Expose
    private var breed: String? = null

    @SerializedName("country")
    @Expose
    private var country: String? = null

    @SerializedName("origin")
    @Expose
    private var origin: String? = null

    @SerializedName("coat")
    @Expose
    private var coat: String? = null

    @SerializedName("pattern")
    @Expose
    private var pattern: String? = null

    fun getBreed(): String? {
        return breed
    }

    fun setBreed(breed: String?) {
        this.breed = breed
    }

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country: String?) {
        this.country = country
    }

    fun getOrigin(): String? {
        return origin
    }

    fun setOrigin(origin: String?) {
        this.origin = origin
    }

    fun getCoat(): String? {
        return coat
    }

    fun setCoat(coat: String?) {
        this.coat = coat
    }

    fun getPattern(): String? {
        return pattern
    }

    fun setPattern(pattern: String?) {
        this.pattern = pattern
    }
}
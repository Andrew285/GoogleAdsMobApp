package com.example.taskforapptech.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private var retrofitMovieInstance: Retrofit? = null
    private var retrofitCatInstance: Retrofit? = null
    private var retrofitWeatherInstance: Retrofit? = null
    private var MOVIE_BASE_URL = "https://api.themoviedb.org/3/"
    private var CAT_BREED_BASE_URL = "https://catfact.ninja/"
    private var WEATHER_BASE_URL = "https://goweather.herokuapp.com/"

    val movieApiService: MovieApiService
        get() {
            if (retrofitMovieInstance == null) {
                retrofitMovieInstance = Retrofit.Builder()
                    .baseUrl(MOVIE_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitMovieInstance!!.create(MovieApiService::class.java)
        }

    val catBreedApiService: CatBreedApiService
        get() {
            if (retrofitCatInstance == null) {
                retrofitCatInstance = Retrofit.Builder()
                    .baseUrl(CAT_BREED_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitCatInstance!!.create(CatBreedApiService::class.java)
        }

    val weatherApiService: WeatherApiService
        get() {
            if (retrofitWeatherInstance == null) {
                retrofitWeatherInstance = Retrofit.Builder()
                    .baseUrl(WEATHER_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofitWeatherInstance!!.create(WeatherApiService::class.java)
        }
}


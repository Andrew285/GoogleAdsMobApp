package com.example.taskforapptech.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.taskforapptech.model.CatBreed
import com.example.taskforapptech.model.Movie
import com.example.taskforapptech.model.Weather
import com.example.taskforapptech.repository.CatBreedsRepository
import com.example.taskforapptech.repository.MovieRepository
import com.example.taskforapptech.repository.WeatherRepository


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val movieRepository: MovieRepository
    private val catBreedsRepository: CatBreedsRepository
    private val weatherRepository: WeatherRepository

    init {
        movieRepository = MovieRepository(application)
        catBreedsRepository = CatBreedsRepository()
        weatherRepository = WeatherRepository()
    }

    val allMovies: LiveData<List<Movie>>
        get() = movieRepository.getMutableLiveData()

    val allCatBreeds: LiveData<List<CatBreed>>
        get() = catBreedsRepository.getMutableLiveData()

    val allWeatherData: LiveData<List<Weather>>
        get() = weatherRepository.getMutableLiveData()
}


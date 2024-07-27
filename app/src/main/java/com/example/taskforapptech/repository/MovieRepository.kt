package com.example.taskforapptech.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskforapptech.retrofit.MovieApiService
import com.example.taskforapptech.R
import com.example.taskforapptech.retrofit.RetrofitInstance
import com.example.taskforapptech.model.Movie
import com.example.taskforapptech.model.results.MovieResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepository(private val application: Application) {
    private var movies: ArrayList<Movie> = ArrayList<Movie>()
    private val mutableLiveData: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()

    fun getMutableLiveData(): LiveData<List<Movie>> {
        val movieApiService: MovieApiService = RetrofitInstance.movieApiService
        val call: Call<MovieResult?>? =
            movieApiService.getPopularMovies(application.getString(R.string.api_key))
        call?.enqueue(object : Callback<MovieResult?> {
            override fun onResponse(call: Call<MovieResult?>, response: Response<MovieResult?>) {
                val result: MovieResult? = response.body()
                if (result?.getResults() != null) {
                    movies = result.getResults() as ArrayList<Movie>
                    mutableLiveData.value = movies
                }
            }

            override fun onFailure(call: Call<MovieResult?>, t: Throwable) {}
        })
        return mutableLiveData
    }
}

package com.example.taskforapptech.retrofit

import com.example.taskforapptech.model.results.CatBreedResult
import retrofit2.Call
import retrofit2.http.GET

interface CatBreedApiService {
    @GET("breeds")
    fun getBreeds(): Call<CatBreedResult?>?
}


package com.example.taskforapptech.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskforapptech.model.CatBreed
import com.example.taskforapptech.model.results.CatBreedResult
import com.example.taskforapptech.retrofit.CatBreedApiService
import com.example.taskforapptech.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CatBreedsRepository() {
    private var catBreeds: ArrayList<CatBreed> = ArrayList()
    private val mutableLiveData: MutableLiveData<List<CatBreed>> = MutableLiveData<List<CatBreed>>()

    fun getMutableLiveData(): LiveData<List<CatBreed>> {
        val catBreedApiService: CatBreedApiService = RetrofitInstance.catBreedApiService
        val call: Call<CatBreedResult?>? =
            catBreedApiService.getBreeds()
        call?.enqueue(object : Callback<CatBreedResult?> {
            override fun onResponse(call: Call<CatBreedResult?>, response: Response<CatBreedResult?>) {
                val result: CatBreedResult? = response.body()
                if (result?.getData() != null) {
                    catBreeds = result.getData() as ArrayList<CatBreed>
                    mutableLiveData.value = catBreeds
                }
            }

            override fun onFailure(call: Call<CatBreedResult?>, t: Throwable) {}
        })
        return mutableLiveData
    }
}

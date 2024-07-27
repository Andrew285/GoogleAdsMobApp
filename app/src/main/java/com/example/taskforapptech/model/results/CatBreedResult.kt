package com.example.taskforapptech.model.results

import com.example.taskforapptech.model.CatBreed
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




class CatBreedResult {
    @SerializedName("data")
    @Expose
    private var data: List<CatBreed?>? = null

    fun getData(): List<CatBreed?>? {
        return data
    }

    fun setData(data: List<CatBreed?>?) {
        this.data = data
    }
}
package com.example.taskforapptech.model.results

import com.example.taskforapptech.model.Movie
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieResult {
    @SerializedName("page")
    @Expose
    private var page: Int? = null

    @SerializedName("results")
    @Expose
    private var results: List<Movie?>? = null

    @SerializedName("total_pages")
    @Expose
    private var totalPages: Int? = null

    @SerializedName("total_results")
    @Expose
    private var totalResults: Int? = null

    fun getPage(): Int? {
        return page
    }

    fun setPage(page: Int?) {
        this.page = page
    }

    fun getResults(): List<Movie?>? {
        return results
    }

    fun setResults(results: List<Movie?>?) {
        this.results = results
    }

    fun getTotalPages(): Int? {
        return totalPages
    }

    fun setTotalPages(totalPages: Int?) {
        this.totalPages = totalPages
    }

    fun getTotalResults(): Int? {
        return totalResults
    }

    fun setTotalResults(totalResults: Int?) {
        this.totalResults = totalResults
    }

}
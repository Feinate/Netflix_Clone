package com.example.netflix.network.Response

import com.example.netflix.domain.model.Movie
import com.example.netflix.network.model.MovieDto
import com.google.gson.annotations.SerializedName

data class MovieResponse (

    @SerializedName("page")
    val page: Int,

    @SerializedName("results")
    val results: List<Movie>
)
package com.example.netflix.network.model

import com.google.gson.annotations.SerializedName

data class MovieDto(

    @SerializedName("poser_path")
    val poster_path: String? = null,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("released_date")
    val released_date: String? = null,

    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("original_title")
    val original_title: String? = null,

    @SerializedName("vote_count")
    val vote_count: Int? = 0,

    @SerializedName("vote_average")
    val vote_average: Float? = null
)
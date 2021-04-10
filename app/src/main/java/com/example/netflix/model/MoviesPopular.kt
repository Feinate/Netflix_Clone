package com.example.netflix.model

import com.google.gson.annotations.SerializedName

data class Results (

    @SerializedName("poser_path")
    val poster_path: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("released_date")
    val released_date: String,

    @SerializedName("id")
    val id: Int,

    @SerializedName("original_title")
    val original_title: String,

    @SerializedName("vote_count")
    val vote_count: Int,

    @SerializedName("vote_average")
    val vote_average: Int
)
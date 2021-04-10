package com.example.netflix.model

import com.google.gson.annotations.SerializedName

data class ResponseModel (

//    @SerializedName("page")
//    val page: Int,

    @SerializedName("results")
    val results: List<Results>
)
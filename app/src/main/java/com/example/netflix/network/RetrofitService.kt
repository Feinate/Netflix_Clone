package com.example.netflix.network

import com.example.netflix.model.ResponseModel
import com.example.netflix.utils.Constants.URL_LIST_POPULAR_MOVIE
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {

    @GET(URL_LIST_POPULAR_MOVIE)
    suspend fun getPopularMovies(): Response<List<ResponseModel>>


}
package com.example.netflix.network

import com.example.netflix.domain.model.Movie
import com.example.netflix.network.Response.MovieResponse
import com.example.netflix.network.model.MovieDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {

    @GET("3/movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") api_key: String,
        @Query("language") language: String,
        @Query("page") page: Int
    ): MovieResponse
}
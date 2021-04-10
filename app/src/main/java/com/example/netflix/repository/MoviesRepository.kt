package com.example.netflix.repository

import com.example.netflix.network.RetrofitInstance

class MoviesRepository {

    suspend fun getPopularMovies() = RetrofitInstance.api.getPopularMovies()

}
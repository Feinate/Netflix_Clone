package com.example.netflix.repository

import com.example.netflix.domain.model.Movie
import com.example.netflix.network.RetrofitInstance
import com.example.netflix.network.RetrofitService

class MovieRepository() {
    
    var client: RetrofitService = RetrofitInstance.api

    suspend fun getPopularMovies(api_key: String, language: String, page: Int) =
        client.getPopularMovies(api_key, language, page)
}
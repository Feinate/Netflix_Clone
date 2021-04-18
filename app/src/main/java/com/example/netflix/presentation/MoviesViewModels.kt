package com.example.netflix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.netflix.repository.MovieRepository
import kotlinx.coroutines.Dispatchers

class MoviesViewModels() : ViewModel() {
    val repository: MovieRepository = MovieRepository()

    val movies = liveData(Dispatchers.IO) {
        val retrievedMovies = repository.getPopularMovies(
            api_key = "66141d569d3691aa6514ae9e6dcda50a",
            language = "en-Us",
            page = 1
        )
        emit(retrievedMovies)
    }
    val news = liveData(Dispatchers.IO) {
        val retrievedMovies = repository.getPopularMovies(
            api_key = "66141d569d3691aa6514ae9e6dcda50a",
            language = "en-Us",
            page = 2
        )
        emit(retrievedMovies)
    }
}
package com.example.netflix.presentation.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.netflix.presentation.MoviesViewModels
import com.example.netflix.repository.MovieRepository

class MoviesViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModels::class.java)) {
            return MoviesViewModels() as T
        }
        throw IllegalArgumentException("ViewModelNotFound")
    }
}
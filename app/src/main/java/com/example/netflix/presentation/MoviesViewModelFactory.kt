package com.example.netflix.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MoviesViewModelFactory(): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MoviesViewModels::class.java)) {
            return MoviesViewModels() as T
        }
        throw IllegalArgumentException("ViewModelNotFound")
    }
}
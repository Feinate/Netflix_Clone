package com.example.netflix.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.netflix.domain.model.Movie
import com.example.netflix.network.Response.MovieResponse
import com.example.netflix.presentation.MoviesViewModels
import com.example.netflix.presentation.components.HomeWallpaper
import com.example.netflix.presentation.components.ListMovies
import com.example.netflix.presentation.components.Navigation
import com.example.netflix.presentation.theme.NetflixTheme

class ActivityHome : ComponentActivity() {

    //lateinit var moviesViewModel: MoviesViewModels

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //moviesViewModel = ViewModelProvider(viewModelStore, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MoviesViewModels::class.java)
            //val popularMovieState: State<MovieResponse?> = moviesViewModel.movies.observeAsState()
            NetflixTheme {
                Navigation()
            }
        }
    }
}
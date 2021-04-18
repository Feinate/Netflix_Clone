package com.example.netflix.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.example.netflix.network.Response.MovieResponse
import com.example.netflix.presentation.MoviesViewModels
import com.example.netflix.presentation.components.HomeWallpaper
import com.example.netflix.presentation.components.ListMovies
import com.example.netflix.presentation.components.parentViewModel

@ExperimentalComposeUiApi
@Composable
fun HomeScreen(navController: NavHostController, it: NavBackStackEntry) {
    val moviesViewModel: MoviesViewModels = it.parentViewModel(navController = navController)
    val popularMovieState: State<MovieResponse?> = moviesViewModel.movies.observeAsState()
    val tendanceMovieState: State<MovieResponse?> = moviesViewModel.news.observeAsState()
    Scaffold(backgroundColor = Color.Black) {
        val scrollState = rememberScrollState()
        Column(Modifier.verticalScroll(scrollState)) {
            HomeWallpaper()
            Spacer(modifier = Modifier.height(20.dp))
            popularMovieState.value?.let {
                ListMovies("Ma liste", it.results)
            }
            Spacer(modifier = Modifier.height(36.dp))
            popularMovieState.value?.let {
                ListMovies("Les plus populaires", it.results)
            }
            Spacer(modifier = Modifier.height(20.dp))
            tendanceMovieState.value?.let {
                ListMovies("Tendance aux USA", it.results)
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}
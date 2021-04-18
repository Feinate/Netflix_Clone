package com.example.netflix.presentation.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.netflix.domain.model.Movie
import com.example.netflix.presentation.theme.Typography

val netflixSansFamily = FontFamily(
    Font(com.example.netflix.R.font.netflixsanslight, FontWeight.Light),
    Font(com.example.netflix.R.font.netflixsansregular, FontWeight.Normal),
    Font(com.example.netflix.R.font.netflixsansmedium, FontWeight.Medium),
    Font(com.example.netflix.R.font.netflixsansbold, FontWeight.Bold),
    Font(com.example.netflix.R.font.netflixsansblack, FontWeight.Black)
)

@Composable
fun ListMovies(text: String, movies: List<Movie?>) {
    Column {
        Text(text = text, Modifier.padding(start = 10.dp),fontSize = 20.sp,fontFamily = netflixSansFamily, fontWeight = FontWeight.Bold, color = Color.White)
        Spacer(modifier = Modifier.height(2.dp))
        LazyRow(
            contentPadding = PaddingValues(start = 6.dp, end = 6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .background(Color.Transparent)
        ) {
            itemsIndexed(movies) { index, movie ->
                MovieCard(title = movie!!.original_title!!, imageUrl = "https://image.tmdb.org/t/p/original${movie.poster_path}")
            }
        }
    }

}
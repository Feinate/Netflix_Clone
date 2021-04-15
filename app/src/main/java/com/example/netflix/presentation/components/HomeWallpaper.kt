package com.example.netflix.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester.Companion.createRefs
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.netflix.R
import com.google.accompanist.coil.CoilImage

@ExperimentalComposeUiApi
@Composable
fun HomeWallpaper() {
    ConstraintLayout(
        modifier = Modifier
            .height(560.dp)
            .fillMaxWidth()
    ) {
        val (blockBottom, Image) = createRefs()

        CoilImage(
            data = "https://image.tmdb.org/t/p/original/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg",
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .constrainAs(Image) {
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            contentScale = ContentScale.Crop
        )
    }
}
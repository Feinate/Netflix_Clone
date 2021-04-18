package com.example.netflix.presentation.components

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.request.ImageRequest
import com.example.netflix.R
import com.google.accompanist.coil.CoilImage
//import com.google.accompanist.coil.CoilImage
import kotlinx.coroutines.launch

@Composable
fun MovieCard(
    modifier: Modifier = Modifier,
    //id: Int,
    imageUrl: String,
    title: String,
) {
    Card(
        modifier = modifier
            .padding(
                horizontal = 4.dp
            )
            .height(160.dp)
            .width(110.dp),
        shape = RoundedCornerShape(6.dp)
    ) {
        CoilImage(
            modifier = Modifier.fillMaxSize(),
            data = imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = title,
            fadeIn = true
        ) {
            Box(Modifier.matchParentSize().background(Color.Black))
        }
    }
}
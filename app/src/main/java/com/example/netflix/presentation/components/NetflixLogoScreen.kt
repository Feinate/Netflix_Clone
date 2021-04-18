package com.example.netflix.presentation.components

import android.media.tv.TvContract
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.netflix.R
import kotlinx.coroutines.delay
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

@Composable
fun NetflixLogoAnimation() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (box, by) = createRefs()
        BoxWithConstraints(
            modifier = Modifier
                .constrainAs(box) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                },
            contentAlignment = Alignment.Center
        ) {
            NetflixLogo()
        }
        Text(
            text = "By Mehdi NECIB",
            fontFamily = netflixSansFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = Color.White,
            modifier = Modifier
                .padding(16.dp)
                .constrainAs(by) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )
    }

}

@Composable
fun NetflixLogo() {
    val resource: Painter = painterResource(id = R.drawable.netflix_logo)
    Image(
        painter = resource,
        modifier = Modifier
            .size(250.dp)
//            .graphicsLayer {
//                scaleX = animatedProgress.value
//                scaleY = animatedProgress.value }
        ,
        contentDescription = "Netflix_logo"
    )
}
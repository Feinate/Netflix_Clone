package com.example.netflix.presentation.components

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.example.netflix.R
import com.example.netflix.presentation.theme.NetflixRed

@Composable
fun StartScreen() {
    AllScreen(Modifier)
}

@Composable
fun AllScreen(modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .fillMaxSize()
    ) {
        val (bottomBlock, topBlock, image, gradient) = createRefs()

        //Background
        Image(
            painterResource(R.drawable.strangedeux),
            null,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxSize()
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                }
        )

        //Gradient Background
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 0.0f,
                        endY = 1900.0f
                    )
                )
                .fillMaxHeight()
                .fillMaxWidth()
                .constrainAs(gradient) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )

        //Block du bas
        Box(
            modifier = modifier
                .padding(14.dp)
                .wrapContentHeight()
                .constrainAs(bottomBlock) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        ) {
            Column {
                TextBlock(text = "Films, séries TV\net bien plus en\nillimité.", size = 40, modifier = Modifier)
                Spacer(modifier = Modifier.height(25.dp))
                TextBlock(text = "Où que vous soyez. Annulable à\ntout moment.", size = 19, modifier = Modifier)
                Spacer(modifier = Modifier.height(40.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = NetflixRed,
                        contentColor = Color.White
                    ),
                    modifier = modifier
                        .fillMaxWidth(),
                    shape = MaterialTheme.shapes.small
                ) {
                    Text(text = "COMMENCER",
                        fontFamily = netflixSansFamily,
                        fontWeight = FontWeight.Normal,
                        fontSize = 15.sp,
                        modifier = modifier.padding(7.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun TextBlock(text: String, size: Int, modifier: Modifier) {
    Text(
        text = text,
        fontFamily = netflixSansFamily,
        fontWeight = FontWeight.Medium,
        color = Color.White,
        fontSize = size.sp,
        textAlign = TextAlign.Center,
        modifier = modifier.fillMaxWidth()
    )
}
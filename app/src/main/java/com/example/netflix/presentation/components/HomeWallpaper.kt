package com.example.netflix.presentation.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Info
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.coil.CoilImage

@ExperimentalComposeUiApi
@Composable
fun HomeWallpaper() {
    ConstraintLayout(
        modifier = Modifier
            .height(560.dp)
            .fillMaxWidth()
    ) {
        val (blockBottom, background, gradient) = createRefs()

        //BackgroundImage
        CoilImage(
            data = "https://image.tmdb.org/t/p/original/ulzhLuWrPK07P1YkdWQLZnQh1JL.jpg",
            contentDescription = "",
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
                .constrainAs(background) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                },
            contentScale = ContentScale.Crop
        )

        //GradientBackground
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 0.0f,
                        endY = 250.0f
                    )
                )
                .height(70.dp)
                .fillMaxWidth()
                .constrainAs(gradient) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                }
        )

        //Constraint for 3 buttons
        ConstraintLayout(
            modifier = Modifier
                .constrainAs(blockBottom) {
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            val (addButton, buttonPlay, infos) = createRefs()
            var isAddOrList by remember { mutableStateOf(false) }
            val iconChange = if (isAddOrList) Icons.Filled.Check else Icons.Filled.Add
            val context = LocalContext.current

            //Add Button
            Box (modifier = Modifier
                .padding(end = 48.dp)
                .constrainAs(addButton) {
                    end.linkTo(buttonPlay.start)
                    bottom.linkTo(parent.bottom)
                }){
                val interactionSource = remember { MutableInteractionSource() }

                Column{
                    IconButton(
                        onClick = {
                            isAddOrList = !isAddOrList
                            if (isAddOrList) {
                                Toast.makeText(context, "Ajoute a Ma liste", Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(context, "Supprime de Ma liste", Toast.LENGTH_SHORT).show()
                            }
                        },
                        modifier = Modifier
                            .clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) {}
                            .size(30.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 0.dp)
                    ) {
                        Icon(imageVector = iconChange, contentDescription = null, modifier = Modifier.size(30.dp), tint = Color.White)
                    }
                    Text(text = "Ma liste", Modifier.padding(bottom = 0.dp), fontSize = 10.sp, color = Color.LightGray, fontFamily = netflixSansFamily, fontWeight = FontWeight.Normal)
                }
            }

            //Play Button
            Button(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.small,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color.White,
                    contentColor = Color.Black
                ),
                contentPadding = PaddingValues(start = 8.dp, end = 8.dp, top = 1.dp, bottom = 1.dp),
                modifier = Modifier
                    .constrainAs(buttonPlay) {
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            ) {
                Box {
                    Row {
                        Icon(
                            Icons.Filled.PlayArrow,
                            contentDescription = null,
                            modifier = Modifier
                                .size(34.dp)
                                .padding(end = 5.dp)
                        )
                        Text(
                            text = "Lecture",
                            fontFamily = netflixSansFamily,
                            fontWeight = FontWeight.Medium,
                            fontSize = 16.sp,
                            letterSpacing = (0.5).sp,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .padding(end = 8.dp)
                        )
                    }
                }
            }

            //Infos Button
            Box (modifier = Modifier
                .padding(start = 48.dp)
                .constrainAs(infos) {
                    start.linkTo(buttonPlay.end)
                    bottom.linkTo(parent.bottom)
                }){
                Column{
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier
                            .size(30.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 0.dp)
                    ) {
                        Icon(imageVector = Icons.Outlined.Info, contentDescription = null, modifier = Modifier.size(25.dp), tint = Color.White)
                    }
                    Text(text = "Infos",
                        Modifier
                            .align(Alignment.CenterHorizontally)
                            .padding(bottom = 0.dp), fontSize = 10.sp, color = Color.LightGray, fontFamily = netflixSansFamily, fontWeight = FontWeight.Normal)
                }
            }
        }
    }
}
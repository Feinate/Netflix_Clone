package com.example.netflix.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.ExperimentalComposeUiApi
import com.example.netflix.presentation.components.Navigation
import com.example.netflix.presentation.theme.NetflixTheme

class ActivityHome : ComponentActivity() {

    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixTheme {
                Navigation()
            }
        }
    }
}
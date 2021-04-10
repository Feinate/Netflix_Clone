package com.example.netflix.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.graphics.Color
import com.example.netflix.presentation.components.NetflixLogoAnimation
import com.example.netflix.presentation.theme.NetflixTheme
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ActivityHome : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(backgroundColor = Color.Black) {
                    NetflixLogoAnimation()
                }
            }
        }
    }
}
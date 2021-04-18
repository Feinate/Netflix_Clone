package com.example.netflix.presentation.ui.start

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.graphics.Color
import com.example.netflix.presentation.components.NetflixLogoAnimation
import com.example.netflix.presentation.components.StartScreen
import com.example.netflix.presentation.theme.NetflixTheme
import com.example.netflix.presentation.ui.home.ActivityHome
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ActivityStart : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NetflixTheme {
                Scaffold(backgroundColor = Color.Black) {
                    StartScreen()
                }
            }
        }
        //val window = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
        //getWindow().decorView.setSystemUiVisibility(window)
    }
}
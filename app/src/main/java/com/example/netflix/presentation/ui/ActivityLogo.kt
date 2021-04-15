package com.example.netflix.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.netflix.presentation.components.NetflixLogoAnimation
import com.example.netflix.presentation.theme.NetflixTheme
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class ActivityLogo : ComponentActivity() {
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
        val window = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT
        getWindow().decorView.setSystemUiVisibility(window)

        Executors.newSingleThreadScheduledExecutor().schedule({
            Log.i("errorrr", "bon")
            val intent = Intent(this, ActivityHome::class.java)
            startActivity(intent)
        }, 1350, TimeUnit.MILLISECONDS)

    }
}
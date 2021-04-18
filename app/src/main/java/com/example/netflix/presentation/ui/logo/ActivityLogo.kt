package com.example.netflix.presentation.ui.logo

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.graphics.Color
import com.example.netflix.presentation.components.NetflixLogoAnimation
import com.example.netflix.presentation.theme.NetflixTheme
import com.example.netflix.presentation.ui.home.ActivityHome
import com.example.netflix.presentation.ui.start.ActivityStart
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
            val intent = Intent(this, ActivityStart::class.java)
            startActivity(intent)
        }, 1350, TimeUnit.MILLISECONDS)

    }
}
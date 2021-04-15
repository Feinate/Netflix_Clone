package com.example.netflix.utils

import android.graphics.drawable.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.VideoLibrary
import androidx.compose.material.icons.rounded.GetApp
import androidx.compose.material.icons.rounded.VideoLibrary
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val label: String, val icon: ImageVector) {

    object Accueil: Screen("Accueil", "Accueil", Icons.Filled.Home)
    object Prochainement: Screen("Prochainement", "Prochainement", Icons.Rounded.VideoLibrary)
    object Telechargements: Screen("Telechargements", "Telechargements", Icons.Rounded.GetApp)

}

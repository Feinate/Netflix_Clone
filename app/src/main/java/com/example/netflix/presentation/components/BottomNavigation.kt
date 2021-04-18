package com.example.netflix.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.netflix.R
import com.example.netflix.network.Response.MovieResponse
import com.example.netflix.presentation.MoviesViewModels
import com.example.netflix.presentation.theme.NetflixGrey
import com.example.netflix.presentation.ui.home.HomeScreen
import com.example.netflix.utils.Screen
import java.time.format.TextStyle

@ExperimentalComposeUiApi
@Composable
fun Navigation() {
    val navController = rememberNavController()
    val items = listOf(Screen.Accueil, Screen.Prochainement, Screen.Telechargements)

    Scaffold(
        bottomBar = {
            bottomAppNavigation(navController = navController, items)
        }
    ) {
        Box(modifier = Modifier.padding(it)) {
            ScreenController(navController = navController)
        }

    }
}

@Composable
fun bottomAppNavigation(
    navController: NavHostController,
    items: List<Screen>
) {
    BottomNavigation(
        backgroundColor = NetflixGrey,
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

        items.forEach {
            BottomNavigationItem(
                unselectedContentColor = Color.DarkGray,
                selectedContentColor = Color.White,
                icon = { Icon(imageVector = it.icon, contentDescription = null)},
                selected = currentRoute == it.route,
                label = { Text(text = it.label) },
                onClick = {
                    navController.popBackStack(
                        navController.graph.startDestination, false)
                    if (currentRoute != it.route) {
                        navController.navigate(it.route)
                    }
                })
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun ScreenController(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Accueil.route) {
        composable(Screen.Accueil.route) {
            HomeScreen(navController, it)
        }
        composable(Screen.Prochainement.route) {

        }
        composable(Screen.Telechargements.route) {

        }
    }
}

@Composable
inline fun <reified VM : ViewModel> NavBackStackEntry.parentViewModel(
    navController: NavController
): VM {
    // First, get the parent of the current destination
    // This always exists since every destination in your graph has a parent
    val parentId = destination.parent!!.id

    // Now get the NavBackStackEntry associated with the parent
    val parentBackStackEntry = navController.getBackStackEntry(parentId)

    // And since we can't use viewModel(), we use ViewModelProvider directly
    // to get the ViewModel instance, using the lifecycle-viewmodel-ktx extension
    return ViewModelProvider(parentBackStackEntry).get()
}
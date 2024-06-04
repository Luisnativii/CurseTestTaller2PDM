package com.example.coursemanager.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coursemanager.MainViewModel
import com.example.coursemanager.ui.screens.AddScreen
import com.example.coursemanager.ui.screens.EditScreen
import com.example.coursemanager.ui.screens.HomeScreen

@Composable

fun Navigation(

    viewModel: MainViewModel

) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = ScreenRoute.Home.route) {

        composable(ScreenRoute.Home.route) {

            HomeScreen(viewModel, navController)
        }

        composable(ScreenRoute.Add.route) {

            AddScreen(viewModel, navController)
        }

        composable(ScreenRoute.Edit.route) {

            EditScreen(viewModel, navController)
        }
    }

}
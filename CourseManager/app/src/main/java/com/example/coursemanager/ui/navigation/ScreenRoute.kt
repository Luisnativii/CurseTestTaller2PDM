package com.example.coursemanager.ui.navigation

sealed class ScreenRoute(var route: String) {
    object Home : ScreenRoute("home")
    object Add : ScreenRoute("add")
    object Edit : ScreenRoute("edit")
}
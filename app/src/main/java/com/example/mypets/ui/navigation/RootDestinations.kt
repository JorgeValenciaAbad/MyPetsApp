package com.example.mypets.ui.navigation

sealed class RootDestinations (val route: String ){
    object LoginScreen : RootDestinations("login_screen")
    object RegisterScreen : RootDestinations("register_screen")
    object MainScreen : RootDestinations("main_screen")
}
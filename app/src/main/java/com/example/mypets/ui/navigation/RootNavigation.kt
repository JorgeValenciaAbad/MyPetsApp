package com.example.mypets.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mypets.ui.login.LoginScreen
import com.example.mypets.ui.login.LoginViewModel
import com.example.mypets.ui.register.RegisterScreen


@Composable
fun NavigationHost(navController: NavHostController) {


    NavHost(navController = navController, startDestination = RootDestinations.LoginScreen.route) {
        composable(route = RootDestinations.LoginScreen.route) {
           LoginScreen(
                navController = navController,
                viewModel = LoginViewModel()
            )
        }
        composable(route = RootDestinations.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(route = RootDestinations.MainScreen.route) {
            //MainScreen()
        }
    }
}

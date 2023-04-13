package com.example.mypets.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mypets.ui.login.LoginScreen
import com.example.mypets.ui.login.LoginViewModel
import com.example.mypets.ui.main.MainScreen
import com.example.mypets.ui.register.RegisterScreen


@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun NavigationHost(navController: NavHostController) {


    NavHost(navController = navController, startDestination = Destination.LoginScreen.route) {
        composable(route = Destination.LoginScreen.route) {
           LoginScreen(
                navController = navController,
                viewModel = LoginViewModel()
            )
        }
        composable(route = Destination.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(route = Destination.MainScreen.route) {
           MainScreen()
        }
    }
}

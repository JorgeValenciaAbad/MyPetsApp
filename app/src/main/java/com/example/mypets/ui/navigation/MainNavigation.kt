package com.example.mypets.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mypets.ui.main.ProfileScreen
import com.example.mypets.ui.pet.PetsScreen

@Composable
fun NavigationHostMain(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Destination.Home.route) {
//        composable(route = Destination.Home.route){
//            HomeScreen()
//        }
        composable(route = Destination.Pets.route){
            PetsScreen()
        }
        composable(route = Destination.Profile.route){
            ProfileScreen()
        }
        composable(route = Destination.Details.route){

        }
    }
}
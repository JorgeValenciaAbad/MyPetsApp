package com.example.mypets.ui.navigation

import com.example.mypets.ui.profile.ProfileScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mypets.ui.pet.PetsScreen

@Composable
fun NavigationHostMain(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Destination.Pets.route) {

        composable(route = Destination.Pets.route){
            PetsScreen(navController)
        }
        composable(route = Destination.Profile.route){
            ProfileScreen(navController)
        }
        composable(route = Destination.Details.route){

        }
    }
}
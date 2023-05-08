package com.example.mypets.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mypets.ui.app.AppScreen
import com.example.mypets.ui.details.DetailsScreen
import com.example.mypets.ui.lost.ListPetsMissingScreen
import com.example.mypets.ui.lost.LostScreen
import com.example.mypets.ui.pet.PetsScreen
import com.example.mypets.ui.profile.ProfileScreen


@Composable
fun NavigationHostMain(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Destination.Pets.route) {

        composable(route = Destination.Pets.route){
            PetsScreen(navController)
        }
        composable(route = Destination.Profile.route){
            ProfileScreen(navController)
        }
        composable(route = Destination.MissList.route){
            ListPetsMissingScreen(navController)
        }
        composable(route = Destination.Lost.route){
            LostScreen(navController)
        }
        composable(route = Destination.Details.route){
            val pet = it.arguments?.getString("id")
            if (pet!= null){
                DetailsScreen(navController = navController, pet.toString().toInt() )
            }else {
                PetsScreen(navController = navController)
            }
        }
        composable(route = Destination.MainScreen.route) {
            AppScreen()
        }
    }
}
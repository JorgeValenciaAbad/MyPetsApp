package com.example.mypets.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mypets.domain.model.Pet

sealed class Destination(val route : String) {

    object LoginScreen : Destination("login_screen")
    object RegisterScreen : Destination("register_screen")
    object MainScreen : Destination("main_screen")
    object Pets : Destination("pets")
    object Profile : Destination("profile")
    object Details : Destination("details/{pet_id}"){
        fun createRoute (pet_id: Int) = "details/${pet_id}"
    }
}
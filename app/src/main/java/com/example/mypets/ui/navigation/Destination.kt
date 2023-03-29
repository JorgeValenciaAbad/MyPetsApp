package com.example.mypets.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Destination(val route : String, val title : String, val icon : ImageVector) {

    object Home : Destination("home", "Home", Icons.Filled.Home)
    object Pets : Destination("pets","Pets", Icons.Filled.Search)
    object Profile : Destination("profile", "Profile", Icons.Filled.Person)
    object Details : Destination("details", "Details", Icons.Filled.Search)
}
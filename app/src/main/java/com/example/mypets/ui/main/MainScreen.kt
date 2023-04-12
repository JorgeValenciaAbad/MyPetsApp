package com.example.mypets.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.mypets.ui.navigation.NavigationHostMain
import com.example.mypets.ui.theme.MyPetsTheme


@Composable
fun MainScreen() {

    val navController = rememberNavController()
        MyPetsTheme(isLogin = false) {
            NavigationHostMain(navController = navController )
        }


}
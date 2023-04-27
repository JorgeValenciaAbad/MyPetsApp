package com.example.mypets.ui.app

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.rememberNavController
import com.example.mypets.ui.navigation.NavigationHost
import com.example.mypets.ui.navigation.NavigationHostMain
import com.example.mypets.ui.theme.MyPetsTheme
import dagger.hilt.android.lifecycle.HiltViewModel

@Composable
fun AppScreen(viewModel: AppViewModel = hiltViewModel()){

    val flag = viewModel.flag
    MyPetsTheme(flag) {
        if (flag){
            val navController = rememberNavController()
            NavigationHost(navController = navController)
        }else{
            val navController = rememberNavController()
            NavigationHostMain(navController = navController)
        }
    }

}
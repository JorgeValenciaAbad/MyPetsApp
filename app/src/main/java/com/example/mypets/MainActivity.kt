package com.example.mypets

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.mypets.ui.navigation.NavigationHost
import com.example.mypets.ui.pet.PetsScreen
import com.example.mypets.ui.theme.MyPetsTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                    //val navController = rememberNavController()
                    //NavigationHost(navController = navController)
            MyPetsTheme(isLogin = false) {
                PetsScreen()
            }


            }
        }
    }
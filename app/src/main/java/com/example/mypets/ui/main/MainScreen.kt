package com.example.mypets.ui.main

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.mypets.ui.navigation.NavigationHostMain
import com.example.mypets.ui.theme.MyPetsTheme


@SuppressLint("SuspiciousIndentation")
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun MainScreen() {

    val navController = rememberNavController()
        MyPetsTheme(isLogin = false) {
            NavigationHostMain(navController = navController )
        }


}
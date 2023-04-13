package com.example.mypets.ui.details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.mypets.R
import com.example.mypets.ui.Header

@Composable
fun DetailsScreen(navController: NavController, pet: Int){
    Log.d("PET", pet.toString())
    Column {
        Header(navController = navController, code = 3)
        Image(painter = painterResource(id = R.drawable.gato), contentDescription = "ImagePet" )


    }


}

@Composable
fun ButtonAdoption(){}
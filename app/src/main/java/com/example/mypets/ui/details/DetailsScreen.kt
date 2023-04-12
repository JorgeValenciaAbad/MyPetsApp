package com.example.mypets.ui.details

import android.util.Log
import android.widget.Button
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.mypets.R
import com.example.mypets.domain.model.Pet
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
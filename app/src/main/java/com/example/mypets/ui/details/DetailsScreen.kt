package com.example.mypets.ui.details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mypets.R
import com.example.mypets.ui.Header
import java.util.*

@Composable
fun DetailsScreen(navController: NavController, pet: Int){
    Log.d("PET", pet.toString())
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        Header(navController = navController, code = 3)
        LazyColumn( horizontalAlignment = Alignment.CenterHorizontally) {

            item{
                ImagePet()
                Card (modifier = Modifier.padding(20.dp)){
                    DataPet()
                    DescriptionPet()
                }

                ButtonAdoption()
            }
        }


    }

}

@Composable
fun DataPet() {
    Column {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(40.dp), Arrangement.SpaceBetween) {

            Text(
                text = "Jorge".uppercase(Locale.getDefault()),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 24.sp
            )
            Text(
                text = "Age: " + "4" + "m old.",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 24.sp)

        }
    }
}

@Composable
fun DescriptionPet(){
    Text(text = "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen. No sólo sobrevivió 500 años, sino que tambien ingresó como texto de relleno en documentos electrónicos, quedando esencialmente igual al original. Fue popularizado en los 60s con la creación de las hojas \"Letraset\", las cuales contenian pasajes de Lorem Ipsum, y más recientemente con software de autoedición, como por ejemplo Aldus PageMaker, el cual incluye versiones de Lorem Ipsum.", modifier = Modifier.padding(20.dp))
}
@Composable
fun ImagePet(){
    Image(painter = painterResource(id = R.drawable.gato), contentDescription = "ImagePet" )

}


@Composable
fun ButtonAdoption(){
    Button(onClick = { /*TODO*/ },
        Modifier
            .fillMaxWidth()
            .padding(20.dp)) {
        Text(text = "Adoption")
    }
}
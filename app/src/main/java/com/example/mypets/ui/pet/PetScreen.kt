package com.example.mypets.ui.pet

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mypets.domain.model.Pet
import com.example.mypets.ui.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Scaffold(topBar = { Header(navController = navController, code = 1)}) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            TitlePetsScreen()
            FilterAdoption()
            PetsAdoption(navController)
        }
    }
}

@Composable
fun FilterAdoption() {
    val types = listOf("Perro", "Gato", "Pajaro")
    //val types: List<String> by viewModel.type.observeAsState(initial = emptyList())
    LazyRow(contentPadding = PaddingValues(5.dp)) {
        items(types.size) {
            ItemType(type = types[it])
        }
    }
}

@Composable
fun PetsAdoption(navController: NavController) {
    val pets = listOf(
        Pet( "Jorge", "perro", 4,"Pastor Aleman", "Amable y sociable", false),
        Pet( "Jorge", "perro", 4,"Pastor Aleman", "Amable y sociable", false),
        Pet( "Jorge", "perro", 4,"Pastor Aleman", "Amable y sociable", false),
        Pet( "Jorge", "perro", 4,"Pastor Aleman", "Amable y sociable", false),
        Pet( "Jorge", "perro", 4,"Pastor Aleman", "Amable y sociable", false),
        Pet( "Jorge", "perro", 4,"Pastor Aleman", "Amable y sociable", false),
        Pet( "Jorge", "perro", 4,"Pastor Aleman", "Amable y sociable", false)
    )
    //val pets:List<Pets> by viewModel.pets.observeAsState(initial = emptyList())

    Column {
        pets.forEach { pet ->
            ItemList(navController = navController, pet = pet)
        }

    }
}

@Composable
fun TitlePetsScreen(){
    Column(Modifier.padding(20.dp)) {
        Text(
            text = "Find your favorite",
            fontWeight = FontWeight.Light,
            fontSize = 20.sp,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
        Text(
            text = "Pet to Adopt!",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 26.sp,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
    }
}
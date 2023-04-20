package com.example.mypets.ui.pet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mypets.domain.model.Pet
import com.example.mypets.ui.*


@Composable
fun PetsScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(verticalArrangement = Arrangement.SpaceBetween){
        Header(navController,1)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        ) {
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
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false)
    )
    //val pets:List<Pets> by viewModel.pets.observeAsState(initial = emptyList())

    Column {
        pets.forEach { pet ->
            ItemList(navController = navController,pet = pet)
        }

    }
}

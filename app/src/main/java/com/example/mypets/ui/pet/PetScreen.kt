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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.domain.model.Pet
import com.example.mypets.ui.*
import kotlinx.coroutines.runBlocking


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsScreen(navController: NavController, viewModel: PetViewModel = hiltViewModel()) {
    val scrollState = rememberScrollState()
    runBlocking {
        viewModel.getData()
    }
    Scaffold(topBar = { Header(navController = navController, code = 1)}) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(it)
                .verticalScroll(scrollState)
        ) {
            TitlePetsScreen()
            FilterAdoption(viewModel)
            PetsAdoption(navController, viewModel)
        }
    }
}

@Composable
fun FilterAdoption(viewModel: PetViewModel) {

    val types: List<String> by viewModel.type.observeAsState(initial = emptyList())
    LazyRow(contentPadding = PaddingValues(5.dp)) {
        items(types.size) {
            ItemType(type = types[it])
        }
    }
}

@Composable
fun PetsAdoption(navController: NavController, viewModel: PetViewModel) {

    val pets:List<Pet> by viewModel.pets.observeAsState(initial = emptyList())

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
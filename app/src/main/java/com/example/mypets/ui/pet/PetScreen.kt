package com.example.mypets.ui.pet

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.R
import com.example.mypets.domain.model.Pet
import com.example.mypets.ui.*
import com.example.mypets.ui.navigation.Destination
import kotlinx.coroutines.runBlocking


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PetsScreen(navController: NavController, viewModel: PetViewModel = hiltViewModel()) {
    val scrollState = rememberScrollState()
    runBlocking {
        viewModel.getData()
    }
    Scaffold(topBar = { TopAppBarPet(navController = navController) }) {
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
        item{
            ItemType("All" , viewModel )
        }
        items(types.size) {
            ItemType(type = types[it], viewModel)
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarPet(navController: NavController) {

    TopAppBar(
        title = {
            Text(
                text = "My Pets",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        actions = {
            IconButton(
                onClick = { navController.navigate(Destination.Profile.route) },
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Profile",
                        tint = MaterialTheme.colorScheme.surface,
                    )
                }

            }
            IconButton(
                onClick = { navController.navigate(Destination.MissList.route) },
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        painter = painterResource(R.drawable.baseline_pets_24),
                        contentDescription = "Lost",
                        tint = MaterialTheme.colorScheme.surface,
                    )
                }

            }
        }
    )
}
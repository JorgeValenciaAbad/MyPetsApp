package com.example.mypets.ui.pet

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mypets.data.local.DataStoreManager
import com.example.mypets.domain.model.Pets
import com.example.mypets.ui.*
import kotlinx.coroutines.launch


@Composable
fun PetsScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Box(modifier = Modifier.fillMaxWidth()){
        Header(navController,1)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 120.dp, horizontal = 20.dp)
                .verticalScroll(scrollState)
        ) {
            FilterAdoption()
            PetsAdoption()
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
fun PetsAdoption() {
    val pets = listOf(
        Pets(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pets(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pets(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pets(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pets(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pets(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pets(1, "Jorge", "perro", 4, "Amable y sociable", false)
    )
    //val pets:List<Pets> by viewModel.pets.observeAsState(initial = emptyList())

    Column {
        pets.forEach { pet ->
            ItemList(pet = pet)
        }

    }
}

package com.example.mypets.ui.pet

import android.util.Log
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
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
import com.example.mypets.data.local.DataStoreManager
import com.example.mypets.domain.model.Pets
import com.example.mypets.ui.*
import kotlinx.coroutines.launch

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PetsScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val lifecycle = LocalLifecycleOwner.current
    var isLoading by remember { mutableStateOf(true) }
    LaunchedEffect(lifecycle.lifecycle) {
        scope.launch {
            val token = DataStoreManager().getToken(context)
            Log.d("TOKEN", token.toString())
            if (!token.isNullOrBlank()) {
                //viewModel.getData(token)
                isLoading = false
            }
        }
    }
    if (isLoading) {
        LazyColumn(modifier = Modifier
            .fillMaxSize().padding(20.dp)){
            item {
                TitleAdoption()
                FilterAdoption()
                PetsAdoption()
            }
        }
    } else {
        LoadingScreen()
    }
}
@Composable
fun TitleAdoption(){
    Column(modifier = Modifier.padding(20.dp)){
        Text(text = "Find your favorite", fontWeight = FontWeight.Light, fontSize = 24.sp, color = if (isSystemInDarkTheme()) Color.White else Color.Black)
        Text( text = "Pet to Adopt!", fontWeight = FontWeight.ExtraBold, fontSize = 36.sp, color = if (isSystemInDarkTheme()) Color.White else Color.Black)
    }
}
@Composable
fun FilterAdoption(){
    val types = listOf("Perro", "Gato", "Pajaro")
    //val types: List<String> by viewModel.type.observeAsState(initial = emptyList())
    LazyRow(contentPadding = PaddingValues(5.dp)){
        items(types.size){
            ItemType(type = types[it])
        }
    }
}
@Composable
fun PetsAdoption(){
    val pets = listOf(Pets(1,"Jorge", "perro",4,"Amable y sociable", false))
    //val pets:List<Pets> by viewModel.pets.observeAsState(initial = emptyList())

    Column {
        pets.forEach{pet->
            ItemList(pet = pet)
        }

    }
}

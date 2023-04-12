package com.example.mypets.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mypets.R
import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User
import com.example.mypets.ui.Header
import com.example.mypets.ui.ItemList
import com.example.mypets.ui.UserPetItem

@Composable
fun ProfileScreen(navController: NavHostController) {

    val userState  =  remember {
        mutableStateOf(User("Jorge","1234","jorge@gmail.com",1))
    }
    Column(Modifier.fillMaxSize()) {
        Header(navController, 2)
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
            ImageUser()
           DataUser(user = userState.value)

        }
    }
}
@Composable
fun ImageUser(){
    Image(
        painter = painterResource(id = R.drawable.profile_photo),
        contentDescription = "User image",
        modifier = Modifier
            .padding(10.dp)
            .size(100.dp),
        Alignment.Center,
        contentScale = ContentScale.Fit
    )
}

@Composable
fun DataUser(user: User){
    Column {
        Text(
            text = "Username: " + user.name, modifier = Modifier
                .padding(10.dp), textAlign = TextAlign.Center, color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )

        Text(
            text = if (user.rol == 1) "Rol: Client" else "Rol: Admin", modifier = Modifier
                .padding(10.dp), textAlign = TextAlign.Center, color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
    }
}
@Composable
fun UserPetsList() {
    val pets = listOf(
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),
        Pet(1, "Jorge", "perro", 4, "Amable y sociable", false),

    )
    //val pets:List<Pets> by viewModel.pets.observeAsState(initial = emptyList())

    Column {
        pets.forEach { pet ->
            UserPetItem(pet = pet)
        }

    }
}
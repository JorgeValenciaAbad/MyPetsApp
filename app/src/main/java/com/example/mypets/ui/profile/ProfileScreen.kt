package com.example.mypets.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.mypets.R
import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User
import com.example.mypets.ui.Header
import com.example.mypets.ui.UserPetItem

@Composable
fun ProfileScreen(navController: NavHostController) {


    Column {
        Header(navController, 2)
        LazyColumn(Modifier.fillMaxSize()) {
            item{
                UserProfile()
            }

        }
    }

}

@Composable
fun UserProfile(){
    val user =  remember { mutableStateOf(User("Jorge","1234","jorge@gmail.com")) }
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        ImageUser()
        DataUser(user =user.value)
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

    }
}
package com.example.mypets.ui.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mypets.R
import com.example.mypets.domain.model.User
import com.example.mypets.ui.ArrowBackIcon
import com.example.mypets.ui.LogoutIcon
import com.example.mypets.ui.UserEmail
import com.example.mypets.ui.UserPhone
import kotlinx.coroutines.runBlocking

@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel= hiltViewModel()) {

    runBlocking {
        viewModel.getUser()
    }
    val user by viewModel.user.observeAsState(initial = User())
    Column {
        TopBarProfile(navController = navController, viewModel = viewModel)
        LazyColumn(Modifier.fillMaxSize()) {
            item{
                Column (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement= Arrangement.Center
                ) {
                    ImageUser()
                    DataUser(user =user)
                }
                ProfileForm(viewModel = viewModel)
                DeleteUser(navController = navController, viewModel =viewModel )
            }

        }
    }

}

@Composable
fun ImageUser() {
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
fun DataUser(user: User) {
    Column {
        Text(
            text = "Username: " + user.name,
            modifier = Modifier
                .padding(10.dp),
            textAlign = TextAlign.Center,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )

        Text(
            text = "Email: " + user.email,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )

        Text(
            text = "Phone: " + user.phone,
            modifier = Modifier.padding(10.dp),
            textAlign = TextAlign.Center,
            color = if (isSystemInDarkTheme()) Color.White else Color.Black
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)

@Composable
fun ProfileForm(viewModel: ProfileViewModel){
    val phoneText: String by viewModel.phone.observeAsState(initial = "")
    val emailText: String by viewModel.email.observeAsState(initial = "")
    val isEnable: Boolean by viewModel.hashChange.observeAsState(initial = false)
    val keyboardController = LocalSoftwareKeyboardController.current

    UserEmail(keyboardController = keyboardController, email = emailText){viewModel.onEmailChanged(it)}
    UserPhone(keyboardController = keyboardController, phone = phoneText){viewModel.onPhoneChanged(it)}
    Button(onClick = { viewModel}, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp), enabled = isEnable) {
        Text(text = "Change")
    }

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarProfile(navController: NavController, viewModel: ProfileViewModel){
    TopAppBar(
        navigationIcon = { ArrowBackIcon(navController) },
        actions = { LogoutIcon(navController, viewModel) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            Text(
                text = "Profile",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
            )
        })
}


@Composable
fun DeleteUser(navController: NavController, viewModel: ProfileViewModel){
    Button(onClick = { viewModel}, modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Red,
            contentColor = Color.White
        )
        ){
        Text(text = "Delete User")
    }
}
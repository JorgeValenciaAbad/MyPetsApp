package com.example.mypets.ui.profile

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mypets.domain.model.BaseResponse
import com.example.mypets.domain.model.User
import com.example.mypets.ui.*
import com.example.mypets.ui.navigation.Destination
import kotlinx.coroutines.runBlocking

@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = hiltViewModel()) {

    runBlocking {
        viewModel.getUser()
    }

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri ->
            runBlocking {
                uri?.let { viewModel.changeAvatar(uri) }
                viewModel.getUser()
            }
        }
    )
    val response: BaseResponse? by viewModel.response.observeAsState(initial = null)
    val user by viewModel.user.observeAsState(initial = User())
    Column {
        TopBarProfile(navController = navController, viewModel = viewModel)
        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Images(
                        imageName = user.image,
                        modifier = Modifier
                            .padding(10.dp)
                            .size(100.dp)
                            .clip(CircleShape)
                            .clickable {
                                singlePhotoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            },
                    )
                    DataUser(user = user, viewModel)
                }
                Button(
                    onClick = {
                        runBlocking {
                            viewModel.delete(user)
                            if (response?.code == 0) navController.navigate(Destination.MainScreen.route)
                        }
                    }, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Delete User")
                }
            }

        }
    }

}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DataUser(user: User, viewModel: ProfileViewModel) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val name: String by viewModel.name.observeAsState(initial = user.name)
    val email: String by viewModel.email.observeAsState(initial = user.email.toString())
    val phone: String? by viewModel.phone.observeAsState(initial = user.phone)
    val profileEnable: Boolean by viewModel.profileEnable.observeAsState(initial = false)
    Column {


        UserName(keyboardController, name) {
            viewModel.onLoginChanged(
                it,
                email,
                phone
            )
        }

        UserEmail(keyboardController, email) {
            viewModel.onLoginChanged(
                name,
                it,
                phone
            )
        }

        UserPhone(keyboardController, phone) {
            viewModel.onLoginChanged(
                name,
                email,
                it
            )
        }
        Button(
            onClick = { runBlocking { viewModel.update(user) } }, modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), enabled = profileEnable
        ) {
            Text(text = "Update")
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarProfile(navController: NavController, viewModel: ProfileViewModel) {
    TopAppBar(
        navigationIcon = { ArrowBackIcon(navController) },
        actions = { LogoutIcon(navController, viewModel) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
        title = {
            Text(
                text = "Profile",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 26.sp,
                color = MaterialTheme.colorScheme.surface
            )
        })
}


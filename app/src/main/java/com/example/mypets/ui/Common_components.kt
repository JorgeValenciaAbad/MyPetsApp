package com.example.mypets.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mypets.R
import com.example.mypets.domain.model.Pet
import com.example.mypets.ui.navigation.Destination
import com.example.mypets.ui.pet.PetViewModel
import com.example.mypets.ui.profile.ProfileViewModel
import kotlinx.coroutines.runBlocking
import java.util.*

@Composable
fun Logo() {
    Image(
        painter = if (isSystemInDarkTheme()) painterResource(id = R.drawable.logo_dark) else painterResource(
            id = R.drawable.logo_light
        ),
        contentDescription = "Logo",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp),
        alignment = Alignment.TopCenter
    )
}

@Composable
fun ImagePet(id: Int) {
    Image(
        painter = painterResource(id = id),
        contentDescription = stringResource(R.string.dog),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(100.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        alignment = Alignment.Center
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemList(navController: NavController, pet: Pet) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        modifier = Modifier.padding(10.dp),
        onClick = { navController.navigate(Destination.Details.createRoute(pet.id)) }) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,

            ) {

            when (pet.type) {
                stringResource(R.string.dog) -> {
                    ImagePet(id = R.drawable.perro)
                }
                stringResource(R.string.cat) -> {
                    ImagePet(id = R.drawable.gato)
                }
                stringResource(R.string.bird) -> {
                    ImagePet(id = R.drawable.pajaro)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), Arrangement.Center
            ) {

                Text(
                    text = pet.name.uppercase(Locale.getDefault()),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                InfoItem(imageVector = Icons.Filled.Place, text = pet.location)
            }


        }
    }
}


@Composable
fun UserPetItem(pet: Pet) {
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,

            ) {

            when (pet.type) {
                stringResource(R.string.dog) -> {
                    ImagePet(id = R.drawable.perro)
                }
                stringResource(R.string.cat) -> {
                    ImagePet(id = R.drawable.gato)
                }
                stringResource(R.string.bird) -> {
                    ImagePet(id = R.drawable.pajaro)
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp), Arrangement.Center
            ) {

                Text(
                    text = pet.name.uppercase(Locale.getDefault()),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center,
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
                Text(
                    text = "Age: " + pet.age.toString() + "m old.",
                    color = if (isSystemInDarkTheme()) Color.White else Color.Black
                )
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemType(type: String) {
    Card(
        modifier = Modifier
            .padding(10.dp),
        onClick = { },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer
        )
    ) {
        Text(
            text = type,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UserName(
    keyboardController: SoftwareKeyboardController?,
    username: String,
    onTextFieldChanged: (String) -> Unit
) {
    TextField(
        value = username,
        onValueChange = onTextFieldChanged,
        label = { Text(text = "Username") },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),
        singleLine = true,

        colors = TextFieldDefaults.textFieldColors(textColor = MaterialTheme.colorScheme.primary),
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "User") },
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UserEmail(
    keyboardController: SoftwareKeyboardController?,
    email: String,
    onTextFieldChanged: (String) -> Unit
) {
    TextField(
        value = email,
        onValueChange = onTextFieldChanged,
        label = { Text(text = "Email") },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "email") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = MaterialTheme.colorScheme.primary),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UserPass(
    keyboardController: SoftwareKeyboardController?,
    password: String,
    onTextFieldChanged: (String) -> Unit
) {


    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = onTextFieldChanged,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),

        singleLine = true,
        label = { Text(text = "Password") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Pass") },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                if (isPasswordVisible) {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_off_24),
                        contentDescription = "Hidden Pass"
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_visibility_24),
                        contentDescription = "Look Pass"
                    )
                }
            }
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = MaterialTheme.colorScheme.primary),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
    )
}
@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UserPhone(
    keyboardController: SoftwareKeyboardController?,
    phone: String,
    onTextFieldChanged: (String) -> Unit
) {
    TextField(
        value = phone,
        onValueChange = onTextFieldChanged,
        label = { Text(text = "Email") },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),
        leadingIcon = { Icon(imageVector = Icons.Filled.Phone, contentDescription = "email") },
        singleLine = true,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(textColor = MaterialTheme.colorScheme.primary),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Header(navController: NavController, code: Int) {

    when (code) {

        1 -> {
            TopAppBar(title = {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = "My Pets",
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 26.sp,
                    )
                }
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
                                tint =  MaterialTheme.colorScheme.surface,
                            )
                        }

                    }
                })


        }
        3 -> {
            TopAppBar(
                navigationIcon = { ArrowBackIcon(navController) },
                actions = { SharedIcon() },
                title = {},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary)
            )
        }
    }
}

@Composable
fun ArrowBackIcon(navController: NavController) {
    IconButton(
        onClick = { navController.popBackStack() },
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "ArrowBack",
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun SharedIcon(){
    IconButton(
        onClick = { },
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Filled.Share,
                contentDescription = "SharePet",
                tint = MaterialTheme.colorScheme.surface,
                modifier = Modifier.size(30.dp)
            )
        }
    }
}

@Composable
fun LogoutIcon(navController: NavController, viewModel: ProfileViewModel) {
    IconButton(
        onClick = {
                  runBlocking {
                      viewModel.logout()
                  }
            navController.navigate(Destination.MainScreen.route)
        },
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(
                imageVector = Icons.Filled.ExitToApp,
                contentDescription = "Logout",
                tint =  MaterialTheme.colorScheme.surface,
                modifier = Modifier.size(30.dp)
            )
        }

    }
}

@Composable
fun ErrorMessage(text: String) {

    Text(
        text = text,
        modifier = Modifier.padding(10.dp),
        color = MaterialTheme.colorScheme.error,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    )

}

@Composable
fun InfoItem(imageVector: ImageVector, text: String) {
    Row(Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Icon(imageVector = imageVector, contentDescription = "", modifier = Modifier.padding(horizontal=5.dp))
        Text(text = text)
    }
}

@Composable
fun InfoItem(image: Int , text: String) {
    Row(Modifier.padding(10.dp), horizontalArrangement = Arrangement.SpaceAround) {
        Image(painter = painterResource(image), contentDescription = "", modifier = Modifier.padding(horizontal=5.dp))
        Text(text = text)
    }
}

@Composable
fun Suitable(value: Boolean, text: String){

    if (value){
        InfoItem(imageVector = Icons.Filled.Check, text = " The animal is suitable for $text")
    }else{
        InfoItem(imageVector = Icons.Filled.Close, text = " The animal is not suitable for $text")
    }

}
package com.example.mypets.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.mypets.R
import com.example.mypets.domain.model.Pets
import java.util.*

@Composable
fun Logo(){
    Image(
        painter =  if (isSystemInDarkTheme())painterResource(id = R.drawable.logo_dark) else painterResource(id = R.drawable.logo_light),
        contentDescription = "Logo",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp),
        alignment = Alignment.TopCenter
    )
}


@Composable
fun ImagePet(id: Int){
    Image(
        painter = painterResource(id = id),
        contentDescription = stringResource(R.string.dog),
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(125.dp)
            .clip(shape = RoundedCornerShape(20.dp)),
        alignment = Alignment.Center
    )
}

@Composable
fun ItemGrid(pet: Pets) {
    val navController = rememberNavController()
    Card(modifier = Modifier
        .size(200.dp)
        .padding(5.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            when (pet.type) {
                stringResource(R.string.dog) -> {
                    Image(
                        painter = painterResource(id = R.drawable.perro),
                        contentDescription = stringResource(R.string.dog) ,
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(height = 150.dp, width = 200.dp),
                        alignment = Alignment.Center
                    )
                }
                stringResource(R.string.cat) -> {
                    Image(
                        painter = painterResource(id = R.drawable.gato),
                        contentDescription = "gato",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .size(height = 150.dp, width = 200.dp),
                        alignment = Alignment.Center
                    )
                }
                stringResource(R.string.bird) -> {
                    Image(
                        painter = painterResource(id = R.drawable.gato),
                        contentDescription = stringResource(R.string.bird),
                        contentScale = ContentScale.Inside,
                        modifier = Modifier
                            .size(200.dp),
                        alignment = Alignment.Center
                    )
                }
            }
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(10.dp), horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = pet.name.uppercase(Locale.getDefault()))
                Text(text = pet.age.toString().uppercase(Locale.getDefault())+" AGE")
            }
        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemList(pet: Pets) {
    Card(
        modifier = Modifier
            .padding(10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        ),
        onClick = { },
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFe0e6c4)
        )) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 30.dp, horizontal = 20.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment =  Alignment.CenterVertically,

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
            Column(modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp), Arrangement.Center){

                Text(text = pet.name.uppercase(Locale.getDefault()), fontWeight = FontWeight.Bold, textAlign = TextAlign.Center)
                Text(text = "Age: "+ pet.age.toString()+"m old.")
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemType(type : String){
    Card(
        modifier = Modifier
            .padding(10.dp),
        onClick = {  }) {
        Text(text = type, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun LoadingScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}


@Composable
fun TitleApp(){
    Text(text = "CUDDLE BUDDIES", modifier = Modifier.fillMaxWidth().padding(20.dp), fontFamily = FontFamily.Serif, fontSize = 24.sp, textAlign = TextAlign.Center)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserName (focusRequester: FocusRequester, username: String, onTextFieldChanged: (String) -> Unit){
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
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "User")},
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions( onNext = {focusRequester.requestFocus()})
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserEmail (focusRequester: FocusRequester,email: String, onTextFieldChanged: (String) -> Unit){
    TextField(
        value = email,
        onValueChange = onTextFieldChanged,
        label = { Text(text = "Email") },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),
        leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "email")},
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(onNext = {focusRequester.requestFocus()})
    )
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun UserPass(focusRequester: FocusRequester, password: String, onTextFieldChanged: (String) -> Unit){

    val keyboardController = LocalSoftwareKeyboardController.current

    var isPasswordVisible by remember { mutableStateOf(false) }

    TextField(
        value = password,
        onValueChange = onTextFieldChanged,
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),

        singleLine = true,
        label = { Text(text = "Password") },
        leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Pass")},
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(onDone = { keyboardController?.hide() }),
    )
}
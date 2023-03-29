@file:Suppress("UNUSED_EXPRESSION")

package com.example.mypets.ui.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mypets.R
import com.example.mypets.data.local.DataStoreManager
import com.example.mypets.ui.mini_components.Background
import com.example.mypets.ui.mini_components.Logo
import com.example.mypets.ui.navigation.RootDestinations
import kotlinx.coroutines.launch


@SuppressLint("SuspiciousIndentation")
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {

    Background()
    LogIn(navController, viewModel)
}

@Composable
fun LogIn(navController: NavController, viewModel: LoginViewModel) {
    val username: String by viewModel.username.observeAsState(initial = "")
    val password: String by viewModel.pass.observeAsState(initial = "")
    Card(
        modifier = Modifier
            .padding(vertical = 70.dp, horizontal = 20.dp)
            .wrapContentHeight()
            .wrapContentWidth()
            .padding()
            .clip(RoundedCornerShape(35.dp)),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            Arrangement.Center
        ) {
            Logo()
            Username(username = username) { viewModel.onLogInChanged(it, password) }
            Pass(pass = password) { viewModel.onLogInChanged(username, it) }
            ButtonSend(viewModel = viewModel, navController = navController)
            ButtonRegister(navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Username(username: String, onTextChange: (String) -> Unit) {
    TextField(
        value = username,
        onValueChange = { onTextChange },
        label = { Text(text = "Username") },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(10.dp)),
        singleLine = true,
        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "User") },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Gray
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Pass(pass: String, onTextChanged: (String) -> Unit) {
    var isPasswordVisible by remember { mutableStateOf(false) }
    TextField(
        value = pass,
        onValueChange = onTextChanged,
        label = { Text(text = "Password") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(CircleShape),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Lock,
                contentDescription = "User"
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            focusedLabelColor = Color.Gray
        ),
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            IconButton(onClick = {
                isPasswordVisible = !isPasswordVisible
            }) {
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
}

@Composable
fun ButtonSend(viewModel: LoginViewModel, navController: NavController) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val loginEnable : Boolean by viewModel.loginEnable.observeAsState(initial = false)
    Button(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(vertical = 20.dp)
        , onClick = {
            viewModel.onLogInSelected()
            if (viewModel.token.toString().isNotEmpty()) {
                scope.launch {
                    DataStoreManager().saveToken(context, viewModel.token.toString())
                }
                navController.navigate(RootDestinations.MainScreen.route)
            } else {
                Log.d("ERROR_LOG_IN_APP", "Error")
            }
        },
        enabled = loginEnable
    ) {
        Text(text = "Log In")
    }
}
@Composable
fun ButtonRegister(navController:NavController){
    ClickableText(
        text = AnnotatedString("Sing Up"),
        onClick = { navController.navigate(RootDestinations.RegisterScreen.route)},
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(40.dp)
    )
}
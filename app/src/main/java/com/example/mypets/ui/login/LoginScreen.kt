package com.example.mypets.ui.login

import android.annotation.SuppressLint
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mypets.ui.*
import com.example.mypets.ui.navigation.RootDestinations
import com.example.mypets.ui.theme.MyPetsTheme


@SuppressLint("SuspiciousIndentation")
@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel) {

    val scrollState = rememberScrollState()

    MyPetsTheme(isLogin = true) {
        Column(Modifier.verticalScroll(scrollState)) {
            LogIn(navController, viewModel)
        }

    }

}

@Composable
fun LogIn(navController: NavController, viewModel: LoginViewModel) {
    val email: String by viewModel.email.observeAsState(initial = "")
    val password: String by viewModel.pass.observeAsState(initial = "")
    val focusRequester = remember { FocusRequester() }

    Card(
        modifier = Modifier
            .padding(vertical = 70.dp, horizontal = 20.dp)
            .wrapContentHeight()
            .wrapContentWidth()
            .padding()
            .clip(RoundedCornerShape(35.dp))
    ) {
        Column{
            Logo()
            UserEmail(focusRequester, email) { viewModel.onLogInChanged(it, password) }
            UserPass(focusRequester,password) { viewModel.onLogInChanged(email, it) }
            LoginButton(viewModel)
            ButtonToRegister(navController)
        }
    }
}


@Composable
fun LoginButton(viewModel: LoginViewModel) {

    val hashLogin by viewModel.loginEnable.observeAsState(initial = false)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(), contentAlignment = Alignment.Center
    ) {

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp, horizontal = 100.dp)
                .clip(RoundedCornerShape(10.dp)),
            onClick = {},
            enabled = hashLogin
        ) {
            Text(text = "Log In")

        }
    }
}
@Composable
fun ButtonToRegister(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        ClickableText(text = AnnotatedString("Register"),
            onClick = { navController.navigate(RootDestinations.RegisterScreen.route)},
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(40.dp),
            style = TextStyle(color = if(isSystemInDarkTheme()) Color.White else Color.Black)
        )
    }
}
package com.example.mypets.ui.register

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.ui.*
import com.example.mypets.ui.navigation.Destination
import com.example.mypets.ui.theme.MyPetsTheme


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel = hiltViewModel()) {
    MyPetsTheme(isLogin = true) {
        val scrollState = rememberScrollState()
        Column( Modifier.verticalScroll(scrollState)) {
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .clip(RoundedCornerShape(35.dp)),
            ) {

                val username: String by viewModel.username.observeAsState(initial = "")
                val email: String by viewModel.email.observeAsState(initial = "")
                val password: String by viewModel.password.observeAsState(initial = "")
                val registerEnable: Boolean by viewModel.registerEnable.observeAsState(initial = false)
                val keyboardController = LocalSoftwareKeyboardController.current
                Column {

                    Logo()

                    UserName(keyboardController,username) { viewModel.onLoginChanged(it, password, email) }

                    UserEmail(keyboardController, email) {
                        viewModel.onLoginChanged(
                            username,
                            password,
                            it
                        )
                    }

                    UserPass( keyboardController, password) {
                        viewModel.onLoginChanged(
                            username,
                            it,
                            email
                        )
                    }

                    RegisterButton(registerEnable)

                    ButtonToLogin(navController)

                }
            }
        }
    }

}

@Composable
fun RegisterButton(registerEnable: Boolean) {
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
            enabled = registerEnable
        ) {
            Text(text = "Sing Up")

        }
    }
}

@Composable
fun ButtonToLogin(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
    ) {
        ClickableText(
            text = AnnotatedString("Log In"),
            onClick = { navController.navigate(Destination.LoginScreen.route) },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(40.dp),
            style = TextStyle(color = if (isSystemInDarkTheme()) Color.White else Color.Black)
        )
    }
}
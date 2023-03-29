package com.example.mypets.ui.register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mypets.ui.mini_components.*
import com.example.mypets.ui.mini_components.Logo
import com.example.mypets.ui.navigation.RootDestinations

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(navController: NavController) {
    Background()
    Card(
        modifier = Modifier
            .padding(20.dp)
            .wrapContentHeight()
            .wrapContentWidth()
            .clip(RoundedCornerShape(35.dp)),
    ) {

        Column(modifier = Modifier.fillMaxSize()) {

            var username by remember { mutableStateOf(TextFieldValue("")) }
            var pass by remember { mutableStateOf(TextFieldValue("")) }
            var email by remember { mutableStateOf(TextFieldValue("")) }
            var passConfirm by remember { mutableStateOf(TextFieldValue("")) }

            Logo()



            TextField(
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                label = { Text(text = "Email") },
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clip(RoundedCornerShape(10.dp)),
                singleLine = true,
                leadingIcon = { Icon(imageVector = Icons.Filled.Email, contentDescription = "email")},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Gray
                )
            )

            TextField(
                value = pass,
                onValueChange = { newText ->
                    pass = newText
                },
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clip(RoundedCornerShape(10.dp)),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                label = { Text(text = "Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "Pass")},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Gray
                )
            )
            TextField(
                value = passConfirm,
                onValueChange = { newText ->
                    passConfirm = newText
                },
                modifier = Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .padding(20.dp)
                    .clip(RoundedCornerShape(10.dp)),
                visualTransformation = PasswordVisualTransformation(),
                singleLine = true,
                label = { Text(text = " Confirm Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                leadingIcon = { Icon(imageVector = Icons.Filled.Lock, contentDescription = "ConfirmPass")},
                colors = TextFieldDefaults.textFieldColors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Gray
                )
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(), contentAlignment = Alignment.Center
            ) {
                Button(modifier = Modifier
                    .wrapContentHeight()
                    .wrapContentWidth()
                    .padding(vertical = 20.dp)
                    .clip(RoundedCornerShape(10.dp)),
                    onClick = {
//                        Actions().addUser(
//                            username.text,
//                            pass.text,
//                            passConfirm.text,
//                            email.text
//                        )
                    }) {
                    Text(text = "Sing Up")
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentAlignment = Alignment.Center
            ) {
                ClickableText(text = AnnotatedString("Back"), onClick = {
                    navController.navigate(RootDestinations.LoginScreen.route)
                })
            }

        }
    }
}
//@Composable
//fun UserName (){
//    TextField(
//        value = username,
//        onValueChange = { newText ->
//            username = newText
//        },
//        label = { Text(text = "Username") },
//        modifier = Modifier
//            .wrapContentHeight()
//            .fillMaxWidth()
//            .padding(20.dp)
//            .clip(RoundedCornerShape(10.dp)),
//        singleLine = true,
//        leadingIcon = { Icon(imageVector = Icons.Filled.Person, contentDescription = "User")},
//        colors = TextFieldDefaults.textFieldColors(
//            focusedIndicatorColor = Color.Transparent,
//            unfocusedIndicatorColor = Color.Transparent,
//            disabledIndicatorColor = Color.Transparent,
//            focusedLabelColor = Color.Gray
//        )
//
//    )
//}
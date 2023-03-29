package com.example.mypets.ui.main

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mypets.domain.model.User
import com.example.mypets.ui.mini_components.*
import com.example.mypets.R
import com.example.mypets.data.local.DataStoreManager
import kotlinx.coroutines.launch

@Preview
@Composable
fun ProfileScreen() {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val lifecycle = LocalLifecycleOwner.current
    var isLoading by remember { mutableStateOf(false) }
    var userState by remember {
        mutableStateOf(User())
    }

    LaunchedEffect(lifecycle.lifecycle) {
        scope.launch {
            val token = DataStoreManager().getToken(context)
            Log.d("TOKEN", token.toString())
            if (!token.isNullOrBlank()) {
        //        val user = getUser(token)
          //      userState = user
                isLoading = true
            }
        }
    }
    if (isLoading){
        Column(modifier = Modifier.fillMaxSize()) {
            TitleApp()
            Image(painter = painterResource(id = R.drawable.chico1), contentDescription = "User image", modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .size(100.dp), Alignment.Center ,contentScale = ContentScale.Fit )

            Text(text = "Username: " + userState.name, modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), textAlign = TextAlign.Center)
            Text(text = if (userState.rol == 1) "Rol: Client" else "Rol: Admin" , modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp), textAlign = TextAlign.Center)

        }
    }else{
        LoadingScreen()
    }


}
//suspend fun getUser(token: String?): User = withContext(Dispatchers.IO) {
//    val service = ShelterServiceSecurity(token).getRetrofit().create(ShelterDAO::class.java)
//    try {
//        val response = service.getUser().execute()
//        if (response.isSuccessful) {
//            response.body() ?: User()
//        } else {
//            Log.d("ERROR_PETS", response.message())
//            User()
//        }
//    } catch (e: Exception) {
//        Log.d("ERROR_PETS", e.toString())
//        User()
//    }
//}
/*fun getUser(token: String?) {
    val service = ShelterServiceSecurity(token)
    service.getUser().enqueue(object : Callback<User> {
        override fun onResponse(call: Call<User>, response: Response<User>) {
            user = response.body()!!
        }

        override fun onFailure(call: Call<User>, t: Throwable) {
            Log.d("ERROR", t.message.toString())
        }
    })
}*/
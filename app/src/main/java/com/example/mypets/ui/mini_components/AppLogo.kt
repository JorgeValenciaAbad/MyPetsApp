package com.example.mypets.ui.mini_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.mypets.R


@Composable
fun Logo(){
    Image(
        //painter =  if (!isSystemInDarkTheme())painterResource(id = R.drawable.logo) else painterResource(id = R.drawable.logo2),
        painter =  painterResource(id = R.drawable.logo),
        contentDescription = "Logo",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .fillMaxWidth()
            .size(200.dp),
        alignment = Alignment.TopCenter
    )
}
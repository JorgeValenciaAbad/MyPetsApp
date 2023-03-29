package com.example.mypets.ui.mini_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun TitleApp(){
    
    Text(text = "CUDDLE BUDDIES", modifier = Modifier.fillMaxWidth().padding(20.dp), fontFamily = FontFamily.Serif, fontSize = 24.sp, textAlign = TextAlign.Center)
}
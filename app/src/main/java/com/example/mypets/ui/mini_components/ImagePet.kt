package com.example.mypets.ui.mini_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mypets.R


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
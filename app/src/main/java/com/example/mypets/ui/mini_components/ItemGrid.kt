package com.example.mypets.ui.mini_components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.mypets.domain.model.Pets
import java.util.*
import com.example.mypets.R

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

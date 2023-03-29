package com.example.mypets.ui.mini_components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mypets.R
import com.example.mypets.domain.model.Pets
import java.util.*

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
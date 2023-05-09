package com.example.mypets.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.R
import com.example.mypets.domain.model.Pet
import com.example.mypets.ui.Images
import com.example.mypets.ui.InfoItem
import com.example.mypets.ui.Suitable
import com.example.mypets.ui.TopBarArrowBack
import com.example.mypets.ui.navigation.Destination
import kotlinx.coroutines.runBlocking

@Composable
fun DetailsScreen(
    navController: NavController,
    idPet: Int,
    viewModel: DetailsViewModel = hiltViewModel()
) {

    runBlocking {
        viewModel.getPet(idPet)
    }
    val pet by viewModel.pet.observeAsState(initial = Pet())
    Column(verticalArrangement = Arrangement.SpaceBetween) {
        TopBarArrowBack(navController = navController, title = pet.name)
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(vertical = 10.dp)
        ) {

            item {
                Images(pet.image, Modifier.padding(20.dp, 10.dp).size(250.dp))
                ButtonAdoption(navController, idPet)
                Card(modifier = Modifier.padding(20.dp, 10.dp)) {
                    DataPet(pet)
                }


            }
        }


    }

}

@Composable
fun DataPet(pet: Pet) {
    Column(Modifier.padding(20.dp)) {

        Text(text = pet.summary, Modifier.padding(10.dp))
        InfoItem(image = R.drawable.sex, text = pet.sex.uppercase())
        InfoItem(image = R.drawable.weight, text = "${pet.size.uppercase()}, ${pet.weight}Kg")
        InfoItem(image = R.drawable.baseline_pets_24, text = pet.breed)
        InfoItem(image = R.drawable.age, text = pet.age.toString() + " year's old")
        InfoItem(imageVector = Icons.Filled.Place, text = pet.location)
        Suitable(value = pet.cats, text = "cats")
        Suitable(value = pet.dogs, text = "dogs")
        Suitable(value = pet.humans, text = "humans")
    }
}



@Composable
fun ButtonAdoption(navController: NavController, idPet: Int) {
    Button(
        onClick = {navController.navigate(Destination.ApplyForAdoption.createRoute(idPet))},
        Modifier
            .fillMaxWidth()
            .padding(20.dp, 10.dp)
    ) {
        Text(text = "Apply for Adoption")
    }
}


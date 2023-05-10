package com.example.mypets.ui.lost

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.ui.ItemMiss
import com.example.mypets.ui.TopBarArrowBack
import com.example.mypets.ui.navigation.Destination
import kotlinx.coroutines.runBlocking

@Composable
fun ListPetsMissingScreen(
    navController: NavController,
    viewModel: LostViewModel = hiltViewModel()
) {

    runBlocking {
        viewModel.getComplaints()
    }

    val petsMissing by viewModel.petsMissing.observeAsState(initial = emptyList())

    Column(verticalArrangement = Arrangement.SpaceBetween) {
        TopBarArrowBack(navController = navController, title = "Pet's Missing")
        Box(contentAlignment = Alignment.BottomCenter){
            Button(
                onClick = { navController.navigate(Destination.Lost.route) },
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Complaint")
            }
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            petsMissing.forEach { petMiss ->
                item { ItemMiss(petMiss = petMiss) }


            }
        }


    }
}
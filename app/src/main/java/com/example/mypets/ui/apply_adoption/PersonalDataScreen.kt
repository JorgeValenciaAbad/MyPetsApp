package com.example.mypets.ui.apply_adoption

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.ui.RadioButtonBoolean
import com.example.mypets.ui.Subtitle
import com.example.mypets.ui.TextFieldForm
import com.example.mypets.ui.TitleScreen
import com.example.mypets.ui.TopBarArrowBack

@Composable
fun FormScreen(navController: NavController, idPet: Int,viewModel: ApplyAdoptionViewModel = hiltViewModel()){

    viewModel.saveIdPet(idPet)

    val identification by viewModel.identification.observeAsState(initial = "")
    val name by viewModel.name.observeAsState(initial = "")
    val secondName by viewModel.secondName.observeAsState(initial = "")
    val bornDate by viewModel.bornDate.observeAsState(initial = "")
    val country by viewModel.country.observeAsState(initial = "")
    val region by viewModel.region.observeAsState(initial = "")
    val address by viewModel.address.observeAsState(initial = "")
    val kids by viewModel.kids.observeAsState(initial = false)
    val pets by viewModel.pets.observeAsState(initial = false)
    val typeHome by viewModel.typeHome.observeAsState(initial = "")
    val home by viewModel.home.observeAsState(initial = "")
    val surface by viewModel.surface.observeAsState(initial = "")


    Column(verticalArrangement = Arrangement.SpaceBetween) {
        TopBarArrowBack(navController = navController, title = "Apply for Adoption")
            LazyColumn(modifier = Modifier.fillMaxWidth() ){
                item{
                    TitleScreen(text = "Personal Data")
                    TextFieldForm(label = "DNI or NIF", text = identification ){viewModel.onIdentificationChange(it)}
                    TextFieldForm(label = "Name", text = name ){viewModel.onNameChange(it)}
                    TextFieldForm(label = "Second Name", text = secondName ){viewModel.onSecondNameChange(it)}
                    TextFieldForm(label = "Region", text = region ){viewModel.onRegionChange(it)}
                    TextFieldForm(label = "Country", text = country ){viewModel.onCountryChange(it)}
                    TextFieldForm(label = "Address", text = address ){viewModel.onAddressChange(it)}
                    TitleScreen(text = "Dwelling")
                    TextFieldForm(label = "Type Home", text = typeHome ){viewModel.onTypeHomeChange(it)}
                    TextFieldForm(label = "Surface", text = surface.toString() ){viewModel.onSurfaceChange(it.toInt())}
                    Subtitle(text = "Your housing is ...")
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Row (verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = home == "Renting",
                                onClick = { viewModel.onHomeChange("Renting")})
                            Text(text = "Renting")
                        }
                        Row(verticalAlignment = Alignment.CenterVertically){
                            RadioButton(
                                selected = home == "Owner",
                                onClick = { viewModel.onHomeChange("Owner")})
                            Text(text = "Owner")
                        }

                    }
                    TitleScreen(text = "Family")
                    Subtitle(text = "Do you have children?")
                    RadioButtonBoolean(value = kids, viewModel, 1)
                    Subtitle(text = "Do you have any pets?")
                    RadioButtonBoolean(value = pets, viewModel, 2)
                    Button(onClick = { }, modifier = Modifier.fillMaxWidth().padding(20.dp)) {
                        Text(text = "Send Apply")
                    }
                }
            }
    }
}

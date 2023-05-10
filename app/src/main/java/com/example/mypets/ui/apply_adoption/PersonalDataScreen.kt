package com.example.mypets.ui.apply_adoption

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.ui.AddressFieldForm
import com.example.mypets.ui.IdentificationFieldForm
import com.example.mypets.ui.NumberFieldForm
import com.example.mypets.ui.RadioButtonBoolean
import com.example.mypets.ui.Subtitle
import com.example.mypets.ui.TextFieldForm
import com.example.mypets.ui.TopBarArrowBack
import com.example.mypets.util.Functions

@OptIn(ExperimentalMaterial3Api::class)
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
    val enabledSend by viewModel.enableSend.observeAsState(initial = false)


    Column(verticalArrangement = Arrangement.SpaceBetween) {
        TopBarArrowBack(navController = navController, title = "Request for Adoption")
            LazyColumn(modifier = Modifier.fillMaxWidth() ){
                item{
                    IdentificationFieldForm(label = "DNI or NIF", text = identification ){viewModel.onIdentificationChange(it)}
                    TextFieldForm(label = "Name", text = name ){viewModel.onNameChange(it)}
                    TextFieldForm(label = "Second Name", text = secondName ){viewModel.onSecondNameChange(it)}

                    BornDate(viewModel = viewModel, bornDate)
                    TextFieldForm(label = "Region", text = region ){viewModel.onRegionChange(it)}
                    TextFieldForm(label = "Country", text = country ){viewModel.onCountryChange(it)}
                    AddressFieldForm(label = "Address", text = address ){viewModel.onAddressChange(it)}
                    TextFieldForm(label = "Type Home", text = typeHome ){viewModel.onTypeHomeChange(it)}
                    NumberFieldForm(label = "Surface", number = surface){viewModel.onSurfaceChange(it)}
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
                    Subtitle(text = "Do you have children?")
                    RadioButtonBoolean(value = kids, viewModel, 1)
                    Subtitle(text = "Do you have any pets?")
                    RadioButtonBoolean(value = pets, viewModel, 2)
                    Button(
                        onClick = { },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        enabled = enabledSend
                    ) {
                        Text(text = "Send Apply")
                    }
                }
            }
    }
}
@SuppressLint("UnrememberedMutableState")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BornDate(viewModel: ApplyAdoptionViewModel, bornDate: String) {

    val openDialog = remember { mutableStateOf(false) }
    if (openDialog.value) {
        val state = rememberDatePickerState()
        DatePickerDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                        viewModel.onBornDateChange(Functions.toDate(state.selectedDateMillis))
                    },
                ) {
                    Text("OK")
                }
            },
            colors = DatePickerDefaults.colors(containerColor = MaterialTheme.colorScheme.background,
            weekdayContentColor = MaterialTheme.colorScheme.onBackground),
            dismissButton = {
                TextButton(
                    onClick = {
                        openDialog.value = false
                    }
                ) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = state)
        }
    }
    OutlinedButton(
        onClick = { openDialog.value = true },
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Text(text = if (bornDate.isEmpty()) "Select Born Date" else "Born Date: $bornDate")
    }
//    TextField(
//        value = bornDate,
//        onValueChange = {},
//        enabled = false,
//        modifier = Modifier
//            .wrapContentHeight()
//            .fillMaxWidth()
//            .clickable { openDialog.value = true }
//            .padding(20.dp)
//            .clip(RoundedCornerShape(10.dp)),
//        isError = bornDate.isEmpty()

    //)
}
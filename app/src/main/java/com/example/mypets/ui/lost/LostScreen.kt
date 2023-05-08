package com.example.mypets.ui.lost

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mypets.ui.Summary
import com.example.mypets.ui.TopBarArrowBack
import kotlinx.coroutines.runBlocking


@Composable
fun LostScreen(navController: NavController, viewModel: LostViewModel = hiltViewModel()) {

    runBlocking {

    }

    val image: Uri? by viewModel.image.observeAsState(initial = null)
    val summary: String by viewModel.summary.observeAsState("")

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> uri?.let { viewModel.onChangeTextField(it, summary) } }
    )
    Column(verticalArrangement = Arrangement.Center) {
        TopBarArrowBack(navController = navController, title = "Pet's Missing")
        Column {
            Button(
                onClick = {
                    singlePhotoPickerLauncher.launch(
                        PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                    )
                },
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = if (image != null) "Image selected" else "Pick one photo")
            }
            Summary(summary = summary) { image?.let { img -> viewModel.onChangeTextField(img,it) } }
            Box(modifier = Modifier.fillMaxWidth(), Alignment.Center) {
                Button(
                    onClick = {
                        runBlocking {
                            viewModel.create()
                        }
                    },
                    enabled = false
                ) {
                    Text(text = "Complaint")
                }
            }
        }
    }

}
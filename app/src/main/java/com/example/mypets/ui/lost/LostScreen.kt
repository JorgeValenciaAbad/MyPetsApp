package com.example.mypets.ui.lost

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import kotlinx.coroutines.runBlocking


@Composable
fun LostScreen(viewModel: LostViewModel = hiltViewModel()){

    val image: Uri? by viewModel.image.observeAsState(initial = null)

    val singlePhotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> uri?.let { viewModel.saveImage(it) } }
    )

    LazyRow{

        item {
            Button(onClick = {
                singlePhotoPickerLauncher.launch(
                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                )
            }) {
                Text(text = if(image!= null)"Image selected" else "Pick one photo")
            }
        }
        item {
            AsyncImage(model = image, contentDescription = "")
            Log.d("Path", image?.path.toString())
            Log.d("Path", image?.isAbsolute.toString()+ image?.userInfo)
        }


        item {
            Button(onClick = {
                runBlocking {
                    viewModel.create()
                }

            }) {
                Text(text = "Complaint")
            }
        }
    }


}
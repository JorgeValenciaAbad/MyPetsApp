package com.example.mypets.ui.lost

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.util.FileUtils
import com.example.mypets.util.Functions
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class LostViewModel @Inject constructor(@ApplicationContext private val context: Context, private val repository: MyPetsRepositoryImpl): ViewModel() {

    private val _image = MutableLiveData<Uri>()
    val image: LiveData<Uri> = _image

    fun saveImage (image: Uri){
        _image.value = image
    }

    suspend fun create (){
        repository.addComplaint(Functions.uriToMultiPartBody(_image.value?.let {
            FileUtils.getPath(context,
                it
            )
        }),"Holaaaaaaa")
    }
}
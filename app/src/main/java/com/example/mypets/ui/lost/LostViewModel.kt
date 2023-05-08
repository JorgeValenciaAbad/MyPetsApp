package com.example.mypets.ui.lost

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.domain.model.PetMiss
import com.example.mypets.util.FileUtils
import com.example.mypets.util.Functions
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class LostViewModel @Inject constructor(@ApplicationContext private val context: Context, private val repository: MyPetsRepositoryImpl): ViewModel() {

    private val _image = MutableLiveData<Uri>()
    val image: LiveData<Uri> = _image

    private val _summary = MutableLiveData<String>()
    val summary: LiveData<String> = _summary

    private val _missEnable = MutableLiveData<Boolean>()
    val missEnable: LiveData<Boolean> = _missEnable

    private val _petsMissing = MutableLiveData<List<PetMiss>>()
    val petsMissing: LiveData<List<PetMiss>> = _petsMissing

    fun onChangeTextField (image: Uri, text: String){
        _image.value = image
        _summary.value = text
    }
    suspend fun create (){
        repository.addComplaint(Functions.uriToMultiPartBody(_image.value?.let {
            FileUtils.getPath(context,
                it
            )
        }),_summary.value.toString())
    }
    suspend fun getComplaints (){
        _petsMissing.value = repository.getComplaint()
    }
}
package com.example.mypets.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.domain.model.Pet
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.internal.notifyAll
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: MyPetsRepositoryImpl) :
    ViewModel() {

    private val _pet = MutableLiveData<Pet>()
    val pet: LiveData<Pet> = _pet

    private val _enableRequest = MutableLiveData<Boolean>()
    val enableRequest: LiveData<Boolean> = _enableRequest


    suspend fun getData(id: Int) {

        _pet.value = repository.getPet(id)
        _enableRequest.value = repository.validRequest(id)


    }

}

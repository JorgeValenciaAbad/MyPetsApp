package com.example.mypets.ui.pet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.domain.model.Pet
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PetViewModel @Inject constructor(private val repository: MyPetsRepositoryImpl):ViewModel() {

    private val _pets = MutableLiveData<List<Pet>>()
    var pets: LiveData<List<Pet>> = _pets

    private val _type = MutableLiveData<List<String>>()
    var type: LiveData<List<String>> = _type

    suspend fun getData ( ){
        _pets.value = repository.getPets()
        _type.value = repository.getPetsTypes()
    }
}
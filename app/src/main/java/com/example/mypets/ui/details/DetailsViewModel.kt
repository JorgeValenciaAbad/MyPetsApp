package com.example.mypets.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mypets.domain.model.Pet

class DetailsViewModel {

    private val _pet = MutableLiveData<Pet>()
    val pet: LiveData<Pet> = _pet

    fun getPet(id: Int){

    }

}
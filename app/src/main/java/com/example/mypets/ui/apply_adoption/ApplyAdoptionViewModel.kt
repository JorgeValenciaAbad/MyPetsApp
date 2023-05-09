package com.example.mypets.ui.apply_adoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ApplyAdoptionViewModel @Inject constructor(private val repository: MyPetsRepositoryImpl) :
    ViewModel() {

    //Personal Data Live Data

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _identification = MutableLiveData<String>()
    val identification: LiveData<String> = _identification

    private val _secondName = MutableLiveData<String>()
    val secondName: LiveData<String> = _secondName

    private val _bornDate = MutableLiveData<Long>()
    val bornDate: LiveData<Long> = _bornDate

    // Address Live Data

    private val _country = MutableLiveData<String>()
    val country: LiveData<String> = _country

    private val _region = MutableLiveData<String>()
    val region: LiveData<String> = _region

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> = _address

    // Family Live Data

    private val _kids = MutableLiveData<Boolean>()
    val kids: LiveData<Boolean> = _kids

    private val _pets = MutableLiveData<Boolean>()
    val pets: LiveData<Boolean> = _pets

    // Home Live Data

    private val _typeHome = MutableLiveData<String>()
    val typeHome: LiveData<String> = _typeHome

    private val _home = MutableLiveData<String>()
    val home: LiveData<String> = _home

    private val _surface = MutableLiveData<Int>()
    val surface: LiveData<Int> = _surface

    // Pet Live Data

    private val _idPet = MutableLiveData<Int>()
    val idPet: LiveData<Int> = _idPet

    private val _enableSend = MutableLiveData<Boolean>()
    val enableSend: LiveData<Boolean> = _enableSend

    fun onNameChange (name: String) {
        _name.value = name
    }
    fun onSecondNameChange (secondName: String) {
        _secondName.value = secondName
    }
    fun onBornDateChange (bornDate: Long) {
        _bornDate.value = bornDate
    }
    fun onCountryChange (country: String) {
        _country.value = country
    }
    fun onRegionChange (region: String) {
        _region.value = region
    }
    fun onAddressChange (address: String) {
        _address.value = address
    }
    fun onKidsChange (kids: Boolean) {
        _kids.value = kids
    }
    fun onPetsChange (pets: Boolean) {
        _pets.value = pets
    }
    fun onTypeHomeChange (typeHome: String) {
        _typeHome.value = typeHome
    }
    fun onHomeChange (home: String) {
        _home.value = home
    }
    fun onSurfaceChange (surface: Int) {
        _surface.value = surface
    }
    fun saveIdPet (id: Int) {
        _idPet.value = id
    }
    fun onIdentificationChange (identification: String) {
        _identification.value = identification
    }

}
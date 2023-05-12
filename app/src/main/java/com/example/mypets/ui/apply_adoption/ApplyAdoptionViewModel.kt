package com.example.mypets.ui.apply_adoption

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.domain.model.BaseResponse
import com.example.mypets.domain.model.RequestAdoption
import com.example.mypets.util.Functions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ApplyAdoptionViewModel @Inject constructor(private val repository: MyPetsRepositoryImpl) :
    ViewModel() {


    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _identification = MutableLiveData<String>()
    val identification: LiveData<String> = _identification

    private val _secondName = MutableLiveData<String>()
    val secondName: LiveData<String> = _secondName

    private val _bornDate = MutableLiveData<String>()
    val bornDate: LiveData<String> = _bornDate

    private val _country = MutableLiveData<String>()
    val country: LiveData<String> = _country

    private val _region = MutableLiveData<String>()
    val region: LiveData<String> = _region

    private val _address = MutableLiveData<String>()
    val address: LiveData<String> = _address

    private val _kids = MutableLiveData<Boolean>()
    val kids: LiveData<Boolean> = _kids

    private val _pets = MutableLiveData<Boolean>()
    val pets: LiveData<Boolean> = _pets

    private val _typeHome = MutableLiveData<String>()
    val typeHome: LiveData<String> = _typeHome

    private val _home = MutableLiveData<String>()
    val home: LiveData<String> = _home

    private val _surface = MutableLiveData<String>()
    val surface: LiveData<String> = _surface

    private val _idPet = MutableLiveData<Int>()

    private val _enableSend = MutableLiveData<Boolean>()
    val enableSend: LiveData<Boolean> = _enableSend

    private val _code = MutableLiveData<BaseResponse>()
    val code: LiveData<BaseResponse> = _code

    fun onNameChange (name: String) {
        _name.value = name
        verify ()
    }
    fun onSecondNameChange (secondName: String) {
        _secondName.value = secondName
        verify ()
    }
    fun onBornDateChange (bornDate: String) {
        _bornDate.value = bornDate
        verify ()
    }
    fun onCountryChange (country: String) {
        _country.value = country
        verify ()
    }
    fun onRegionChange (region: String) {
        _region.value = region
        verify ()
    }
    fun onAddressChange (address: String) {
        _address.value = address
        verify ()
    }
    fun onKidsChange (kids: Boolean) {
        _kids.value = kids
        verify ()
    }
    fun onPetsChange (pets: Boolean) {
        _pets.value = pets
        verify ()
    }
    fun onTypeHomeChange (typeHome: String) {
        _typeHome.value = typeHome
        verify ()
    }
    fun onHomeChange (home: String) {
        _home.value = home
        verify ()
    }
    fun onSurfaceChange (surface: String) {
        _surface.value = surface
        verify ()
    }
    fun saveIdPet (id: Int) {
        _idPet.value = id
        verify ()
    }
    fun onIdentificationChange (identification: String) {
        _identification.value = identification
        verify ()
    }

    private fun verify (){
       if(Functions.isValidIdentification(identification.value.toString()) || Functions.isValidIdentificationNIE(identification.value.toString()))
           _enableSend.value =  Functions.isValidText(name.value.toString()) && Functions.isValidText(secondName.value.toString()) && Functions.isValidText(region.value.toString()) && Functions.isValidText(country.value.toString()) && Functions.isValidNumber(surface.value.toString()) && Functions.isValidText(typeHome.value.toString()) && !home.value.isNullOrEmpty() && address.value.toString().length>1 && !bornDate.value.toString().isNullOrEmpty()

    }

    suspend fun send(){
       _code.value = repository.adoptionRequest(RequestAdoption(
            _name.value.toString(),
            _identification.value.toString(),
            _secondName.value.toString(),
            _bornDate.value.toString(),
            _country.value.toString(),
            _region.value.toString(),
            _address.value.toString(),
            _kids.value.toString().toBoolean(),
            _pets.value.toString().toBoolean(),
            _typeHome.value.toString(),
            _home.value.toString(),
            _surface.value.toString(),
            _idPet.value.toString().toInt()
        )
       )
    }
}
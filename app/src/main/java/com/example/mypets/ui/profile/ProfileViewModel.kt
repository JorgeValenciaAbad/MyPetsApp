package com.example.mypets.ui.profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.util.Functions
import com.example.mypets.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: MyPetsRepositoryImpl) :
    ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _hashChange = MutableLiveData<Boolean>()
    val hashChange: LiveData<Boolean> = _hashChange

    fun onEmailChanged(email: String){
        _email.value = email
        _hashChange.value = Functions.isValidEmail(email)
    }
    fun onPhoneChanged( phone: String, ){
        _phone.value = phone
        _hashChange.value = phone.length > 9

    }

    fun reset(){
        _phone.value = ""
        _email.value = ""
        _hashChange.value = false
    }

    suspend fun getUser() {
        _user.value = repository.getUser()
    }

    suspend fun logout() {
        repository.logout()
    }
}
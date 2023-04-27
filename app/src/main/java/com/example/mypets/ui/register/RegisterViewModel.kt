package com.example.mypets.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.domain.model.User
import com.example.mypets.util.Functions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: MyPetsRepositoryImpl) :ViewModel() {



    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _registerEnable = MutableLiveData<Boolean>()
    val registerEnable: LiveData<Boolean> = _registerEnable

    private val _code = MutableLiveData<Int>()
    val code: LiveData<Int> = _code

    fun onLoginChanged(username: String, password: String, email: String){
        _username.value = username
        _password.value = password
        _email.value = email
        _registerEnable.value = Functions.isValidEmail(email) && Functions.isValidPassword(password) && Functions.isValidUser(username)

    }

    suspend fun onRegisterSelected(){
        _code.value = repository.register(User(_username.value.toString(),_password.value.toString(),_email.value.toString()))
    }



}
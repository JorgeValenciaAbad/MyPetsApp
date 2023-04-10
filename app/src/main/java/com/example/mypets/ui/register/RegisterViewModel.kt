package com.example.mypets.ui.register

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.util.Constants
import com.example.mypets.util.Functions
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.regex.Matcher
import java.util.regex.Pattern
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor( repository: MyPetsRepositoryImpl) :ViewModel() {



    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _registerEnable = MutableLiveData<Boolean>()
    val registerEnable: LiveData<Boolean> = _registerEnable

    fun onLoginChanged(username: String, password: String, email: String){
        _username.value = username
        _password.value = password
        _email.value = email
        _registerEnable.value = Functions.isValidEmail(email) && Functions.isValidPassword(password) && Functions.isValidUser(username)

    }



}
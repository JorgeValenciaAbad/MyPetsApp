package com.example.mypets.ui.register

import androidx.compose.animation.core.estimateAnimationDurationMillis
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class RegisterViewModel:ViewModel() {

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    private val _confirmPassword = MutableLiveData<String>()
    val confirmPassword: LiveData<String> = _confirmPassword

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _registerEnable = MutableLiveData<String>()
    val registerEnable: LiveData<String> = _registerEnable

    fun onLoginChanged(username: String, password: String, confirmPassword: String, email: String){
        _username.value = username
        _password.value = password
        _confirmPassword.value = confirmPassword
        _email.value = email

    }

    private fun isValidUser(username: String): Boolean = username.length > 1
    private fun isValidPassword(pass: String): Boolean = pass.length > 6

}
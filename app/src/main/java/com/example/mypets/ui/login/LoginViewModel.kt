package com.example.mypets.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class LoginViewModel {
    private  val  _username = MutableLiveData<String>()
    val username : LiveData<String> = _username

    private  val  _pass = MutableLiveData<String>()
    val pass : LiveData<String> = _pass

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable : LiveData<Boolean> = _loginEnable



    fun onLogInChanged(username:String, pass:String){
        _username.value = username
        _pass.value = pass
        _loginEnable.value = isValidPassword(pass) && isValidUser(username)
    }
    private fun isValidUser(username: String): Boolean = username.length > 1
    private fun isValidPassword(pass: String): Boolean = pass.length > 6

    fun onLogInSelected() {
        //_token.value = data(username.value.toString(), pass.value.toString())
    }

}
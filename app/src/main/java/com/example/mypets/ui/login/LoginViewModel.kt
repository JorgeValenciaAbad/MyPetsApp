package com.example.mypets.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.util.Functions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(repository: MyPetsRepositoryImpl):ViewModel() {
    private  val  _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private  val  _pass = MutableLiveData<String>()
    val pass : LiveData<String> = _pass

    private val _loginEnable = MutableLiveData<Boolean>()
    val loginEnable : LiveData<Boolean> = _loginEnable



    fun onLogInChanged(email:String, pass:String){
        _email.value = email
        _pass.value = pass
        _loginEnable.value = Functions.isValidPassword(pass) && Functions.isValidEmail(email)
    }

    fun onLogInSelected() {
        //_token.value = data(email.value.toString(), pass.value.toString())
    }

}
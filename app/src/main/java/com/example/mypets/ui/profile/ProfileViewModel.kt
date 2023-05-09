package com.example.mypets.ui.profile

import android.content.Context
import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import com.example.mypets.domain.model.User
import com.example.mypets.util.FileUtils
import com.example.mypets.util.Functions
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(@ApplicationContext private val context: Context, private val repository: MyPetsRepositoryImpl) :
    ViewModel() {

    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _phone = MutableLiveData<String>()
    val phone: LiveData<String> = _phone

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _profileEnable = MutableLiveData<Boolean>()
    val profileEnable: LiveData<Boolean> = _profileEnable


    suspend fun getUser() {
        _user.value = repository.getUser()
    }

    suspend fun logout() {
        repository.logout()
    }

    suspend fun changeAvatar (uri: Uri): Int{
        return repository.changeAvatar(Functions.uriToMultiPartBody(FileUtils.getPath(context,uri)))
    }

    fun onLoginChanged(name: String, email: String, phone: String){

        _name.value = name
        _email.value = email
        _phone.value = phone

         _profileEnable.value = Functions.isValidEmail(email) && Functions.isValidPhone(phone)|| phone.isNullOrEmpty() && Functions.isValidUser(name)
    }

    suspend fun update(user: User){
        user.name = name.value.toString()
        user.phone = phone.value.toString()
        user.email = email.value.toString()

        repository.updateUser(user)
    }
}
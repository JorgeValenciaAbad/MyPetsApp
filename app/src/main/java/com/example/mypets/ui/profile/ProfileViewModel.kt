package com.example.mypets.ui.profile

import androidx.lifecycle.ViewModel
import com.example.mypets.data.MyPetsRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val repository: MyPetsRepositoryImpl): ViewModel() {

}
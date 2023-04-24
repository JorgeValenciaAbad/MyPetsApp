package com.example.mypets.data

import android.util.Log
import com.example.mypets.data.local.DataStoreManager
import com.example.mypets.data.remote.MyPetsApi
import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User
import com.example.mypets.domain.repository.PetsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyPetsRepositoryImpl(private val myPetsApi: MyPetsApi) : PetsRepository {
    override suspend fun login(email: String, pass: String): Int {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.login(User(email, pass)).execute()
            response.code()
        }

    }

    override suspend fun register(user: User): Int {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.register(user).execute()
            response.code()
        }
    }

    override fun getPets(): ArrayList<Pet> {
        return ArrayList()
    }

    override fun getPet(id: Int): Pet {
        return Pet()
    }
}
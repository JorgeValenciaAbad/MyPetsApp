package com.example.mypets.data

import android.util.Log
import com.example.mypets.data.local.DataStoreManager
import com.example.mypets.data.remote.MyPetsApi
import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User
import com.example.mypets.domain.repository.PetsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyPetsRepositoryImpl (private val myPetsApi: MyPetsApi, private val dataStore: DataStoreManager) : PetsRepository {
    override suspend fun login(email: String, pass: String):Int{
        return withContext(Dispatchers.Default){
            val response = myPetsApi.login(User(email, pass)).execute()
            dataStore.saveToken(response.body().toString())
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.code()
        }

    }

    override suspend fun register(user: User): Int {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.register(user).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.code()
        }
    }

    override suspend fun getPets(): List<Pet>? {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.getPets(dataStore.getToken()).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.body()
        }

    }

    override suspend fun getTypes(): List<String>? {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.getType(dataStore.getToken()).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.body()
        }
    }

    override suspend fun adoption(id: Int): Int {
        return 0
    }

    override suspend fun getUser(): User? {
        return  withContext(Dispatchers.Default){
            val response = myPetsApi.getUser(dataStore.getToken()).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.body()
        }
    }

    override suspend fun filter(type: String): List<Pet>? {
        return  withContext(Dispatchers.Default){
            val response = myPetsApi.getPetsType(dataStore.getToken(), type).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.body()
        }
    }

    override suspend fun logout() {
        dataStore.saveToken("")
    }

    override suspend fun getPet(id: Int): Pet? {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.getPet(dataStore.getToken(), id).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.body()
        }
    }
}
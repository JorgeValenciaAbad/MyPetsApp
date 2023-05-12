package com.example.mypets.data

import android.util.Log
import com.example.mypets.data.local.DataStoreManager
import com.example.mypets.data.remote.MyPetsApi
import com.example.mypets.domain.model.BaseResponse
import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.PetMiss
import com.example.mypets.domain.model.RequestAdoption
import com.example.mypets.domain.model.User
import com.example.mypets.domain.repository.PetsRepository
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MultipartBody

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

    override suspend fun updateUser(user: User): User? {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.updateUser(dataStore.getToken(),user).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.body()
        }
    }

    override suspend fun addComplaint(image: MultipartBody.Part, text: String): Int {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.addComplaint(dataStore.getToken(),image,text).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.code()
        }
    }

    override suspend fun getComplaint(): List<PetMiss>? {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.getComplaint(dataStore.getToken()).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.body()
        }
    }

    override suspend fun changeAvatar(image: MultipartBody.Part): Int {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.changeAvatar(dataStore.getToken(),image).execute()
            Log.d("RESPONSE_CODE", response.code().toString()+" "+response.message())
            response.code()
        }
    }
    override suspend fun adoptionRequest(requestAdoption: RequestAdoption): BaseResponse {
        return withContext(Dispatchers.Default){
            val response = myPetsApi.adoption(dataStore.getToken(),requestAdoption).execute()
            if (response.isSuccessful){
                Log.d("RESPONSE_CODE", response.code().toString())
                return@withContext response.body()!!
            }else{
                val error =
                    Gson().fromJson(
                        response.errorBody()!!.charStream(),
                        BaseResponse::class.java
                    )
                Log.d("RESPONSE_CODE", response.code().toString()+" "+ error.subCode)

                return@withContext error
            }

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
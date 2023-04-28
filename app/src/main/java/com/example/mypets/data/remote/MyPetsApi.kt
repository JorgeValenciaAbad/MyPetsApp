package com.example.mypets.data.remote

import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User
import retrofit2.Call
import retrofit2.http.*

interface MyPetsApi {

    @POST("/api/login")
    fun login (@Body user: User): Call<String>
    @POST("/api/adduser")
    fun register (@Body user: User): Call<String>
    @GET("/api/pets")
    fun getPets(@Header("Authorization") token: String?):Call<List<Pet>>
    @GET("/api/pets/types")
    fun getPetsType(@Header("Authorization") token: String?):Call<List<String>>
    @GET("/api/pets/{id}")
    fun getPet(@Header("Authorization") token: String?, @Path("id") id: Int): Call<Pet>

    @POST("api/user")
    fun getUser(@Header("Authorization") token: String?):Call<User>
}
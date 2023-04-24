package com.example.mypets.data.remote

import com.example.mypets.domain.model.User
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MyPetsApi {

    @POST("/api/login")
    fun login (@Body user: User): Call<String>
    @POST("/api/adduser")
    fun register (@Body user: User): Call<String>
}
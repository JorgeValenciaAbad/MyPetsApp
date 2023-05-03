package com.example.mypets.data.remote

import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface MyPetsApi {

    @POST("/api/user/login")
    fun login (@Body user: User): Call<String>
    @POST("/api/user/adduser")
    fun register (@Body user: User): Call<String>
    @GET("/api/pet")
    fun getPets(@Header("Authorization") token: String?):Call<List<Pet>>
    @GET("/api/pet/types")
    fun getType(@Header("Authorization") token: String?):Call<List<String>>
    @GET("/api/pet/{id}")
    fun getPet(@Header("Authorization") token: String?, @Path("id") id: Int): Call<Pet>
    @POST("api/user")
    fun getUser(@Header("Authorization") token: String?):Call<User>
    @GET("api/pet/type/{type}")
    fun getPetsType(@Header("Authorization") token: String?, @Path("type") type: String):Call<List<Pet>>
    @Multipart
    @POST("/api/pet/complaint")
    fun addComplaint(@Header("Authorization") token: String?, @Part image: MultipartBody.Part, @Query("summary") text:String): Call<Int>
}
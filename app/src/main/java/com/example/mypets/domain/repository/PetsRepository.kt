package com.example.mypets.domain.repository

import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User
import okhttp3.MultipartBody

interface PetsRepository {
    suspend fun login (email: String, pass: String):Int
    suspend fun register(user: User):Int
    suspend fun getPets(): List<Pet>?
    suspend fun getPet(id:Int): Pet?
    suspend fun adoption(id: Int): Int
    suspend fun getUser(): User?
    suspend fun filter(type: String): List<Pet>?
    suspend fun logout ()
    suspend fun getTypes(): List<String>?
    suspend fun updateUser(user: User):User?
    suspend fun addComplaint(image: MultipartBody.Part, text: String): Int
}
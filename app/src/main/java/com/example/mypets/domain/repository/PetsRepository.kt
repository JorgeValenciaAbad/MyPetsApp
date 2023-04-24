package com.example.mypets.domain.repository

import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.model.User

interface PetsRepository {
    suspend fun login (username: String, pass: String): Int

    suspend fun register(user: User):Int
    fun getPets():ArrayList<Pet>
    fun getPet(id:Int): Pet
}
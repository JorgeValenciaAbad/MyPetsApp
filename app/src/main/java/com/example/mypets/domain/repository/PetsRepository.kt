package com.example.mypets.domain.repository

import com.example.mypets.domain.model.Pet
import com.example.mypets.ui.navigation.Destination

interface PetsRepository {
    fun login (username: String, pass: String): Int
    fun getPets():ArrayList<Pet>
    fun getPet(id:Int): Pet
}
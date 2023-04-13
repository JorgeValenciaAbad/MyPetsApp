package com.example.mypets.data

import com.example.mypets.domain.model.Pet
import com.example.mypets.domain.repository.PetsRepository

class MyPetsRepositoryImpl: PetsRepository {
    override fun login(username: String, pass: String): Int {
        return 0
    }

    override fun getPets(): ArrayList<Pet> {
        return ArrayList()
    }

    override fun getPet(id: Int): Pet {
       return Pet()
    }
}
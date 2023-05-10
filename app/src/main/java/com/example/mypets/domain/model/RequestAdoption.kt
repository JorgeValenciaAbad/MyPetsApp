package com.example.mypets.domain.model

data class RequestAdoption(
    private val name: String,
    private val identification: String,
    private val secondName: String,
    private val bornDate: String,
    private val country: String,
    private val region: String,
    private val address: String,
    private val kids: Boolean,
    private val pets: Boolean,
    private val typeHome: String,
    private val home: String,
    private val surface: String,
    private val idPet: Int
)
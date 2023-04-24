package com.example.mypets.domain.model

import java.io.Serializable

class Pet: Serializable {

    var id: Int = 0
    var name: String = ""
    var type: String = ""
    var age: Int = 0
    var breed: String = ""
    var summary: String = ""
    var adoption: Boolean = false





    constructor()
    constructor(
        id: Int,
        name: String,
        type: String,
        age: Int,
        breed: String,
        summary: String,
        adoption: Boolean
    ) {
        this.id = id
        this.name = name
        this.type = type
        this.age = age
        this.breed = breed
        this.summary = summary
        this.adoption = adoption
    }
    constructor(
        name: String,
        type: String,
        age: Int,
        breed: String,
        summary: String,
        adoption: Boolean
    ) {
        this.name = name
        this.type = type
        this.age = age
        this.breed = breed
        this.summary = summary
        this.adoption = adoption
    }

    override fun toString(): String {
        return "Pet(id=$id, name='$name', type='$type', age=$age, breed='$breed', summary='$summary', adoption=$adoption)"
    }


}
package com.example.mypets.domain.model

import java.io.Serializable

class Pet: Serializable {
    var pet_id :Int = 0
    var name : String = ""
    var type :String = ""
    var age: Int = 0
    var description: String = ""
    var reserva:Boolean = false

    constructor(
        pet_id: Int,
        name: String,
        type: String,
        age: Int,
        description: String,
        reserva: Boolean
    ) {
        this.pet_id = pet_id
        this.name = name
        this.type = type
        this.age = age
        this.description = description
        this.reserva = reserva
    }
    constructor(
        name: String,
        type: String,
        age: Int,
        description: String,
        reserva: Boolean
    ) {
        this.pet_id = 0
        this.name = name
        this.type = type
        this.age = age
        this.description = description
        this.reserva = reserva
    }

    constructor()

    override fun toString(): String {
        return "Pets(id=$pet_id, name='$name', type='$type', age=$age, sumary='$description', reserva=$reserva)"
    }
}
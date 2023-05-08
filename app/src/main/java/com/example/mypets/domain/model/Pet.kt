package com.example.mypets.domain.model

import java.io.Serializable


class Pet: Serializable {

    var id: Int = 0
    var name: String = ""
    var type: String = ""
    var age: Int = 0
    var breed: String = ""
    var sex: String = ""
    var size: String = ""
    var weight: Double = 0.0
    var summary: String = ""
    var location: String = ""
    private var adoption: Boolean = false
    var cats: Boolean = false
    var dogs: Boolean = false
    var humans: Boolean = false
    var image: String = ""

    constructor()
    constructor(
        id: Int,
        name: String,
        type: String,
        age: Int,
        breed: String,
        sex: String,
        size: String,
        weight: Double,
        summary: String,
        location: String,
        adoption: Boolean,
        cats:Boolean,
        dogs:Boolean,
        humans:Boolean,
        image:String

    ) {
        this.id = id
        this.name = name
        this.type = type
        this.age = age
        this.breed = breed
        this.sex = sex
        this.size = size
        this.weight = weight
        this.summary = summary
        this.adoption = adoption
        this.location = location
        this.cats = cats
        this.dogs = dogs
        this.humans = humans
        this.image = image
    }

    override fun toString(): String {
        return "Pet(id=$id, name='$name', type='$type', age=$age, breed='$breed', sex='$sex', size='$size', weight=$weight, summary='$summary', location='$location', adoption=$adoption, cats=$cats, dogs=$dogs, humans=$humans)"
    }


}
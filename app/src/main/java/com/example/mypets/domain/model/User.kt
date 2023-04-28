package com.example.mypets.domain.model

import java.io.Serializable

class User: Serializable {

    private var id : Int = 0
    var name: String = ""
    private var pass: String = ""
    var email: String = ""
    var phone:String = ""


    constructor(id: Int, name: String, pass: String, email: String, phone: String){
        this.id = id
        this.name = name
        this.pass = pass
        this.email = email
        this.phone = phone
    }
    constructor(name: String, pass: String, email: String, phone: String){
        this.name = name
        this.pass = pass
        this.email = email
        this.phone = phone
    }

    constructor()

    override fun toString(): String {
        return "User(id=$id, name='$name', pass='$pass', token='$email')"
    }

}
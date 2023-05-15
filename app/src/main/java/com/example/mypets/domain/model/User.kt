package com.example.mypets.domain.model

import java.io.Serializable

class User: Serializable {

    var id : Int = 0
    var name: String = ""
    private var pass: String? = ""
    var email: String? = ""
    var phone: String? = null
    var image: String = ""


    constructor(id: Int, name: String, pass: String, email: String, phone: String, image: String ){
        this.id = id
        this.name = name
        this.pass = pass
        this.email = email
        this.phone = phone
        this.image = image
    }
    constructor(name: String, pass: String, email: String){
        this.name = name
        this.pass = pass
        this.email = email
    }
    constructor(email: String, pass: String){
        this.pass = pass
        this.email = email
    }
    constructor(){
        this.id = 0
        this.name = ""
        this.pass = ""
        this.email = ""
        this.phone = null
        this.image = ""
    }
    override fun toString(): String {
        return "User(name='$name', phone=$phone, email='$email')"
    }

}
package com.example.mypets.domain.model

import java.io.Serializable

class User: Serializable {

    var user_id : Int
    var name:String
    var pass:String
    var email:String
    var rol:Int


    constructor(id : Int, name:String, pass:String, email:String,rol:Int ){
        this.user_id = id
        this.name = name
        this.pass = pass
        this.rol = rol
        this.email = email
    }
    constructor(name:String, pass:String, email: String, rol:Int){
        this.user_id = 0
        this.name = name
        this.pass = pass
        this.rol = rol
        this.email = email
    }
    constructor(){
        this.user_id = 0
        this.name = ""
        this.pass = ""
        this.rol = 1
        this.email = ""
    }
    override fun toString(): String {
        return "User(id=$user_id, name='$name', pass='$pass', rol=$rol, token='$email')"
    }

}
package com.example.mypets.util

object Functions {

    fun isValidUser(username: String): Boolean = username.length > 1
    fun isValidPassword(pass: String): Boolean = Constants.patternPass.matcher(pass).matches()
    fun isValidEmail(email: String): Boolean = Constants.patternEmail.matcher(email).matches()
}
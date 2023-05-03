package com.example.mypets.util

import java.util.regex.Pattern

object Constants {

    private const val PASS_REGEX = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}\$"
    private const val EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"

    //const val BASE_URL = "http://192.168.1.102:5002"
    //const val BASE_URL = "http://192.168.1.13:5002"
    private const val PHONE_REGEX = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}\$"

    const val BASE_URL = "http://192.168.1.106:5002"

    val patternPass : Pattern = Pattern.compile(PASS_REGEX)

    val patternEmail : Pattern = Pattern.compile(EMAIL_REGEX)

    val patternPhone : Pattern = Pattern.compile(PHONE_REGEX)
}
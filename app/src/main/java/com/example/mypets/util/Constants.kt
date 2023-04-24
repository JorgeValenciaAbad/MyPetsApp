package com.example.mypets.util

import java.util.regex.Pattern

object Constants {

    private const val PASS_REGEX = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}\$"
    private const val EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"

    const val BASE_URL = "http://192.168.1.106:5002"

    val patternPass : Pattern = Pattern.compile(PASS_REGEX)

    val patternEmail : Pattern = Pattern.compile(EMAIL_REGEX)
}
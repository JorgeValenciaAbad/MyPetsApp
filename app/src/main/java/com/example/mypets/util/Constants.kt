package com.example.mypets.util

import java.util.regex.Pattern

object Constants {

    private const val PHONE_REGEX = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}\$"
    private const val PASS_REGEX = "^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}\$"
    private const val EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$"
    private const val TEXT_REGEX = "^([A-Za-z]{1,25})\$"
    private const val NUMBER_REGEX = "^([0-9]{1,3})\$"
    private const val IDENTIFICATION_REGEX = "^(\\d{8})([A-Z])\$"
    private const val NIE_REGEX = "^[XYZ]\\d{7,8}[A-Z]\$"
    private const val PASSPORT_REGEX = "^([A-PR-WY-Z]{1}[A-HJ-KM-NP-Z]{1}[0-9]{6}[A-DFM]{0,1})$"
    private const val BRP_REGEX = "^([A-PR-WY-Z]{1}[0-9]{2}[0-9A-HJKMNP-Z]{2}[0-9]{4})$"


    const val BASE_URL = "http://192.168.1.106:5002"
    //const val BASE_URL = "http://192.168.1.102:5002"
    //const val BASE_URL = "http://192.168.1.14:5002"

    const val EMPTY_STRING = ""

    val patternPass : Pattern = Pattern.compile(PASS_REGEX)

    val patternEmail : Pattern = Pattern.compile(EMAIL_REGEX)

    val patternPhone : Pattern = Pattern.compile(PHONE_REGEX)

    val patternText : Pattern = Pattern.compile(TEXT_REGEX)

    val patternNumber : Pattern = Pattern.compile(NUMBER_REGEX)

    val patternIdentification : Pattern = Pattern.compile(IDENTIFICATION_REGEX)

    val patternNIE : Pattern = Pattern.compile(NIE_REGEX)

    val patternPassport : Pattern = Pattern.compile(PASSPORT_REGEX)

    val patternBrp : Pattern = Pattern.compile(BRP_REGEX)

}
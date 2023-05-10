package com.example.mypets.util

import android.icu.text.SimpleDateFormat
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.util.Date

object Functions {

    fun isValidUser(username: String): Boolean = username.length > 1
    fun isValidPassword(pass: String): Boolean = Constants.patternPass.matcher(pass).matches()
    fun isValidEmail(email: String): Boolean = Constants.patternEmail.matcher(email).matches()
    fun isValidSummary(summary: String): Boolean = summary.length > 100
    fun isValidText(text: String): Boolean = text.length > 1 && Constants.patternText.matcher(text).matches()
    fun isValidNumber(number: String): Boolean =  Constants.patternNumber.matcher(number).matches()
    fun isValidPhone(phone: String): Boolean = Constants.patternPhone.matcher(phone).matches()
    fun isValidIdentification(identification: String): Boolean = Constants.patternIdentification.matcher(identification).matches()
    fun isValidIdentificationNIE(identification: String): Boolean = Constants.patternNIE.matcher(identification).matches()
    fun toDate(dateMillis: Long?): String{
        val date = dateMillis?.let { Date(it) }
        val format = SimpleDateFormat("yyyy-MM-dd")
        return format.format(date)
    }
    fun uriToMultiPartBody(path: String?): MultipartBody.Part {
        val file = File(path)
        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("image", file.name, requestBody)
    }
}
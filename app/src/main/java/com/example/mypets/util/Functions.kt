package com.example.mypets.util

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths

object Functions {

    fun isValidUser(username: String): Boolean = username.length > 1
    fun isValidPassword(pass: String): Boolean = Constants.patternPass.matcher(pass).matches()
    fun isValidEmail(email: String): Boolean = Constants.patternEmail.matcher(email).matches()
    fun isValidSummary(summary: String): Boolean = summary.length > 100
    fun isValidPhone(phone: String): Boolean = Constants.patternPhone.matcher(phone).matches()
    fun uriToMultiPartBody(path: String?): MultipartBody.Part {
        val file = File(path)
        val requestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
        return MultipartBody.Part.createFormData("image", file.name, requestBody)
    }
}
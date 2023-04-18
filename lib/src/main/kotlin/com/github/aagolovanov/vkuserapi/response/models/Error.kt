package com.github.aagolovanov.vkuserapi.response.models

import kotlinx.serialization.Serializable

@Serializable
data class Error(private val error: ErrorData) {
    val errorMessage get() = error.errorMsg
    val errorCode get() = error.errorCode

    @Serializable
    data class ErrorData(
        val errorMsg: String,
        val errorCode: Int
    )
}
package com.github.aagolovanov.vkuserapi.response.models

import com.github.aagolovanov.vkuserapi.API
import com.github.aagolovanov.vkuserapi.response.models.regular.Dialogs
import com.github.aagolovanov.vkuserapi.response.models.regular.Text
import kotlin.LazyThreadSafetyMode.NONE


class UserModel(val api: API, val token: String) {
    val dialogs by lazy(NONE) { Dialogs(api, this) }


    // checks if token is valid
//    fun ping() = api.checkToken(token)

    fun ping(): Boolean {
        val response = getStatus()

        return response.response != null
    }

    fun getStatus(): ApiResponse<Text> = api.requestWithToken("status.get", token, Text.serializer())
}
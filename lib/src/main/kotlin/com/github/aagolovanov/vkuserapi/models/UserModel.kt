package com.github.aagolovanov.vkuserapi.models

import com.github.aagolovanov.vkuserapi.API
import com.github.aagolovanov.vkuserapi.models.regular.Dialogs
import kotlin.LazyThreadSafetyMode.NONE


class UserModel(val api: API, val token: String) {
    val dialogs by lazy(NONE) { Dialogs(api, this) }


    // checks if token is valid
    fun ping() {
        api.checkToken(token)
    }
}
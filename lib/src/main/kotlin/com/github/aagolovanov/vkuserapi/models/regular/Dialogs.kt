package com.github.aagolovanov.vkuserapi.models.regular

import com.github.aagolovanov.vkuserapi.API
import com.github.aagolovanov.vkuserapi.models.UserModel

class Dialogs(val api: API, val userModel: UserModel): Iterator<Dialog> {
    val dialogs: List<Dialog> by lazy { fetchDialogs() }
    val size: Int by lazy { getDialogCount() }
    val messages: Iterator<Message> by lazy { TODO("dialog messages iterator") }


    private fun fetchDialogs(): List<Dialog> {
        TODO("Not implemented")
    }


    private fun getDialogCount(): Int {
        TODO("Not yet implemented")
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Dialog {
        TODO("Not yet implemented")
    }
}
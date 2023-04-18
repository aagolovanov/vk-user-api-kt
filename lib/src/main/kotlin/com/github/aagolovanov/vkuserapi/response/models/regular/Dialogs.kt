package com.github.aagolovanov.vkuserapi.response.models.regular

import com.github.aagolovanov.vkuserapi.API
import com.github.aagolovanov.vkuserapi.response.models.UserModel

class Dialogs(val api: API, val userModel: UserModel): Iterator<Conversation> {
    val dialogs: List<Conversation> by lazy { fetchDialogs() }
    val size: Int by lazy { getDialogCount() }
    val messages: Iterator<Message> by lazy { TODO("dialog messages iterator") }


    private fun fetchDialogs(): List<Conversation> {
        TODO("Not implemented")
    }


    private fun getDialogCount(): Int {
        TODO("Not yet implemented")
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    override fun next(): Conversation {
        TODO("Not yet implemented")
    }
}
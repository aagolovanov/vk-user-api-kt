package com.github.aagolovanov.vkuserapi.response.models.regular

import kotlinx.serialization.Serializable


@Serializable
data class Conversation(
    val id: Int,
    val type: String
)
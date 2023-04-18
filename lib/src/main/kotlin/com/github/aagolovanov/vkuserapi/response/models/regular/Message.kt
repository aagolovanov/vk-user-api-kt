package com.github.aagolovanov.vkuserapi.response.models.regular

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject


@Serializable
data class Message(
    val id: Int,
    val date: Int,

    @SerialName("peer_id")
    val peerId: Int,

    @SerialName("from_id")
    val fromId: Int,
    val text: String,

    @SerialName("random_id")
    val randomId: Int,
    val attachments: JsonObject,

    @SerialName("reply_message")
    val replyMessage: Message?,
)
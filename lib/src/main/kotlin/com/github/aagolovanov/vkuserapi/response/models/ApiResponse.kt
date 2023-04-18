package com.github.aagolovanov.vkuserapi.response.models

import com.github.aagolovanov.vkuserapi.JsonDeserializer
import com.github.aagolovanov.vkuserapi.Response
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException

class ApiResponse<T>(rawResponse: String, target: KSerializer<T>) {
    val response: T? = tryDecode(rawResponse, target)?.response

    var error: Error? = null
        private set


    private fun tryDecode(raw: String, target: KSerializer<T>): Response<T>? {
        try {
            val newTarget = Response.serializer(target)

            return JsonDeserializer.decodeFromString(newTarget, raw)
        } catch (e: IllegalArgumentException) {
            tryError(raw)
        } catch (e: SerializationException) {
            TODO("logging")
        }

        return null
    }

    private fun tryError(raw: String) {
        error = JsonDeserializer.decodeFromString(Error.serializer(), raw)
    }
}
package com.github.aagolovanov.vkuserapi

import com.github.aagolovanov.vkuserapi.errors.BadResponseException
import com.github.aagolovanov.vkuserapi.response.models.ApiResponse
import kotlinx.serialization.KSerializer

class API(val client: ApiHTTPClient) {

    fun <Model> requestWithToken(method: String, token: String, target: KSerializer<Model>): ApiResponse<Model> {
        val rawResponse = client.request(
            "https://api.vk.com/method/$method",
            mapOf(
                Pair("access_token", token)
            )
        )?.body()


        if (rawResponse != null) {
            return ApiResponse(rawResponse, target)
        } else {
          throw BadResponseException(method)
        }
    }

}
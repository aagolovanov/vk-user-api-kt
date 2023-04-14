package com.github.aagolovanov.vkuserapi

class API(val client: ApiHTTPClient) {


    // check token with statusGet
    fun checkToken(token: String) {

        val response = client.request(
            "https://api.vk.com/method/status.get",
            mapOf(
                Pair("access_token", token)
            )
        )?.body()




        println(response ?: "null")
    }

    fun test() {
    }

}
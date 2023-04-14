package com.github.aagolovanov.vkuserapi

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Test {
    fun launch() {
        println("Hello World!")

        val t = Testser(5, "asd", listOf(1,2,3))

        val s = Json.encodeToString(t)

        println(s)
    }
}

@Serializable
data class Testser(val a: Int, val b: String, val c: List<Int>)
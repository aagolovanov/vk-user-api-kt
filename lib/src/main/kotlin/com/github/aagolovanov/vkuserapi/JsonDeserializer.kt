package com.github.aagolovanov.vkuserapi

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy


@OptIn(ExperimentalSerializationApi::class)
val JsonDeserializer = Json {
    ignoreUnknownKeys = true
    namingStrategy = JsonNamingStrategy.SnakeCase
}
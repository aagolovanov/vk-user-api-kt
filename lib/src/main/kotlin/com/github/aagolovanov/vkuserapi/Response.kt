package com.github.aagolovanov.vkuserapi

import kotlinx.serialization.Serializable


@Serializable
data class Response<T>(val response: T)
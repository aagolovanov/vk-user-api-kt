package com.github.aagolovanov.vkuserapi

import org.slf4j.LoggerFactory
import java.io.IOException
import java.net.URI
import java.net.URLEncoder.encode
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers
import java.time.Duration
import javax.swing.text.html.HTML.Attribute.HREF

class ApiHTTPClient(client: HttpClient? = null) {
    private val client = client ?: HttpClient.newBuilder()
        .version(HttpClient.Version.HTTP_1_1)
        .followRedirects(HttpClient.Redirect.NEVER)
        .connectTimeout(Duration.ofSeconds(10))
        .build()



    fun request(url: String, data: Map<String, Any>?): HttpResponse<String>? {

        val stringData: String
        = if (data == null) {
            encodeOptions(mapOf("v" to "5.131"))
        } else {
            val newData = data + ("v" to "5.131")
            encodeOptions(newData)
        }

        val builder = HttpRequest.newBuilder(
            URI.create(url)
        )

        val request = builder.POST(HttpRequest.BodyPublishers.ofString(stringData)).build()

        for (i in 1..3) {
            try {
                return client.send(request, BodyHandlers.ofString())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        return null
    }

    private fun encodeOptions(obj: Map<String, Any>?): String {
        if (obj == null) return ""
        val sb = StringBuilder()
        for (o in obj.entries) {
            sb.append(encode(o.key, "utf-8")).append('=')
                .append(encode(o.value.toString(), "utf-8")).append("&")
        }
        return sb.toString()
    }

}
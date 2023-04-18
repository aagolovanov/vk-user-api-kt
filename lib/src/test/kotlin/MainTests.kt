import com.github.aagolovanov.vkuserapi.API
import com.github.aagolovanov.vkuserapi.ApiHTTPClient
import com.github.aagolovanov.vkuserapi.Response
import com.github.aagolovanov.vkuserapi.response.models.Error
import com.github.aagolovanov.vkuserapi.response.models.UserModel
import com.github.aagolovanov.vkuserapi.response.models.regular.Text
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonNamingStrategy
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotEquals

const val TOKEN = ""

@OptIn(ExperimentalSerializationApi::class)
val jsonSerializer = Json {
    ignoreUnknownKeys = true
    namingStrategy = JsonNamingStrategy.SnakeCase
}

class MainTests {
    @Test
    fun testSomething() {
        val json = """{"error":{"error_code":1116,"error_msg":"asd"}}"""

        val obj = jsonSerializer.decodeFromString<Error>(json)

        assertEquals(obj.errorCode, 1116)
        assertEquals(obj.errorMessage, "asd")
    }


    @Test
    fun testPing() {
        val client = ApiHTTPClient()
        val api = API(client)

        val user = UserModel(api, TOKEN)

        assertEquals(user.ping(), true)
    }

    @Test
    fun testBadPing() {
        val client = ApiHTTPClient()
        val api = API(client)

        val user = UserModel(api, "asdasd")
        val result = user.getStatus()

        assertEquals(user.ping(), false)
        assertEquals(result.response, null)
        assertNotEquals(result.error, null)
        assertEquals(result.error?.errorCode, 5)
    }


    @Test
    fun testResponse() {
        val json = """{"response":{"text":"asdasd"}}"""

        val resp = Response(Text("govno"))

        val ser = jsonSerializer.encodeToString(resp)
        val deser = jsonSerializer.decodeFromString<Response<Text>>(json)

        assertEquals(ser, """{"response":{"text":"govno"}}""")
        assertEquals(deser.response.text, "asdasd")
    }

}
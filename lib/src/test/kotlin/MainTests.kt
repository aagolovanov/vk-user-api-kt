import com.github.aagolovanov.vkuserapi.API
import com.github.aagolovanov.vkuserapi.ApiHTTPClient
import com.github.aagolovanov.vkuserapi.models.UserModel
import com.github.aagolovanov.vkuserapi.Test as t
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

const val TOKEN = "vk1.a.YKZDMsl6umYvA9UpxDDxCipmRdS-u6neQC26Vm2YBejAye27h74aLasDtlNELL-wpuH-P_QaOnKMEfV5PB6R1YCI-wRN45r4lt0LA8IQcet8sEeS-544s4ecMC4JFzIVJ8J_AyDSc5fmg8_OG8TIBVVVRtrjiNU03ME6cc7bgkApOIqHrjUM9NVGJpIzegtvPvIZ3HomRTse2wuK9WfgQw"


class MainTests {
    @Test
    fun testSomething() {
        t().launch()
        assertEquals(5,5)
    }


    @Test
    fun testPing() {
        val client = ApiHTTPClient()
        val api = API(client)

        val user = UserModel(api, TOKEN)

        user.ping()
    }
}
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json


fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    val t = Test(5, "asd", listOf(1,2,3))

    val s = Json.encodeToString(t)

    println(s)

}

@Serializable
data class Test(val a: Int, val b: String, val c: List<Int>)
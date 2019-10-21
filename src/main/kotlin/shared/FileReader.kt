package shared

import kotlin.text.Charsets.UTF_8

object FileReader {
    fun readFile(fileName: String): String =
        this::class.java.getResource(fileName)
            .readText(UTF_8)
}

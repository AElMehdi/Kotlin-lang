
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.jsoup.Jsoup.parse

object Main {
    val mapper = jacksonObjectMapper()

    const val HTML_CONTENT = """<!DOCTYPE html>
<html>
<body>

<h1 style="text-align:center;">Centered Heading</h1>
<p style="text-align:center;">Centered paragraph.</p>

</body>
</html>"""

    fun parse(): String? {
        // Read file
        // Parse it (Get a sample title and a content) using jsoup
        // Set the values in the data class
        // write the json
        return parse(HTML_CONTENT).wholeText().trim()
    }

    fun readFile() : String =
   Main::class.java.getResource("htmlContent.html")
       .readText(Charsets.UTF_8)

}

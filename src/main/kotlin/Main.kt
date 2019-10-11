import org.jsoup.Jsoup

object Main {
    const val HTML_CONTENT = """<!DOCTYPE html>
<html>
<body>

<h1 style="text-align:center;">Centered Heading</h1>
<p style="text-align:center;">Centered paragraph.</p>

</body>
</html>"""

    fun parse(): String? {
        return Jsoup.parse(HTML_CONTENT).wholeText().trim()
    }

    fun readFile() : String =
   Main::class.java.getResource("htmlContent.html")
       .readText(Charsets.UTF_8)

}

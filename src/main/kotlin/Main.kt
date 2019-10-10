
import org.jsoup.Jsoup.parse

const val HTML_CONTENT = """<!DOCTYPE html>
<html>
<body>

<h1 style="text-align:center;">Centered Heading</h1>
<p style="text-align:center;">Centered paragraph.</p>

</body>
</html>"""

fun parse(): String? {
    return parse(HTML_CONTENT).wholeText().trim()
}


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import domain.SideEffects
import org.jsoup.Jsoup.parse

object Main {
    private val mapper = jacksonObjectMapper()

    private const val H1_TAG = "h1"
    private const val P_TAG = "p"
    private const val TABLE_TAG = "table"

    fun htmlToSideEffectsJson(): String? {
        // TODO: Rewrite it in an elegant way
        val htmlContent = readFile()
        return mapper.writeValueAsString(htmlToSideEffects(htmlContent))
    }

    private fun htmlToSideEffects(htmlContent: String): SideEffects {
        // TODO: Same applies to this part
        val headerElements = parse(htmlContent).getElementsByTag(H1_TAG)
        val pElements = parse(htmlContent).getElementsByTag(P_TAG)
        return SideEffects(headerElements[0].wholeText(), pElements[0].wholeText())
    }

    fun readFile() : String =
   Main::class.java.getResource("htmlContent.html")
       .readText(Charsets.UTF_8)

    fun getHtmlTable(): String? {
        val htmlString = readFile()
        val table = parse(htmlString).getElementsByTag(TABLE_TAG)
        return table.outerHtml()
    }
}


import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import domain.SideEffects
import org.jsoup.Jsoup.parse
import org.jsoup.nodes.TextNode

object Main {
    private val mapper = jacksonObjectMapper()

    private const val H1_TAG = "h1"
    private const val P_TAG = "p"
    private const val TABLE_TAG = "table"

    fun htmlToSideEffectsJson(): String? {
        return mapper.writeValueAsString(htmlToSideEffects())
    }

    private fun htmlToSideEffects(): SideEffects {
        return SideEffects(title(), sideEffect())
    }

    fun readFile() : String =
   Main::class.java.getResource("htmlContent.html")
       .readText(Charsets.UTF_8)

    fun table(): String? {
        val htmlString = readFile()
        val table = parse(htmlString).getElementsByTag(TABLE_TAG)
        return table.outerHtml()
    }

    fun row(): String {
        val rows = parse(table()).getElementsByTag("tr")
        return rows[1].outerHtml()
    }
    private fun column(): String {
        return (parse(table()).getElementsByTag("tr")[1].select("td")[1].select("br").first()
            .nextSibling() as TextNode).text()
    }


    fun title(): String {
        return parse(row()).getElementsByTag("strong")[0].text()
    }

    fun sideEffect(): String {
        val sideEffect = (parse(row()).select("br").first().nextSibling() as TextNode).text()
        val frequency = column()


        return "$sideEffect $frequency"
    }

}

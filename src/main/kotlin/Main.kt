
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import domain.SideEffects
import org.jsoup.Jsoup.parse

object Main {
    private val mapper = jacksonObjectMapper()

    fun htmlToSideEffectsJson(): String? {
        // TODO: rewrite it in a more elegant way
        val htmlContent = readFile()
        return mapper.writeValueAsString(htmlToSideEffects(htmlContent))
    }

    private fun htmlToSideEffects(htmlContent: String): SideEffects {
        // TODO: Same applies to this part
        val headerElements = parse(htmlContent).getElementsByTag("h1")
        val pElements = parse(htmlContent).getElementsByTag("p")
        return SideEffects(headerElements[0].wholeText(), pElements[0].wholeText())
    }

    fun readFile() : String =
   Main::class.java.getResource("htmlContent.html")
       .readText(Charsets.UTF_8)

}

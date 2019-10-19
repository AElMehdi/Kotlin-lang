import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import domain.SideEffect
import domain.SideEffects
import org.jsoup.Jsoup.parse

object Main {
    private val mapper = jacksonObjectMapper()

    private const val TABLE_TAG = "table"

    fun htmlSideEffectsToJson(): String? {
        return mapper.writeValueAsString(htmlToSideEffects())
    }

    private fun htmlToSideEffects(): SideEffects {
        return SideEffects(sideEffects = sideEffects())
    }

    fun readFile(): String =
        Main::class.java.getResource("htmlContent.html")
            .readText(Charsets.UTF_8)

    fun table(): String? {
        val htmlString = readFile()
        val table = parse(htmlString).getElementsByTag(TABLE_TAG)
        return table.outerHtml()
    }

    private fun row(): Pair<String, String> {
        val rows = parse(table()).select("tr")
        return Pair(rows[1].select("td")[0].outerHtml(), rows[1].select("td")[1].outerHtml())
    }

    fun header(): String {
        return parse(row().first).getElementsByTag("strong")[0].text()
    }

    fun sideEffects(): List<SideEffect> {
        val result = mutableListOf<SideEffect>()
        val frequencies = columns().second.toMutableList()

        for (column in columns().first) {

            val headerAndSideEffects = column.split("</strong>")

            val header = headerAndSideEffects[0]

            val sideEffects = headerAndSideEffects[1].split("<br>")
                .filter { se -> se.isNotEmpty() }
                .map { se -> removeTags(se) }
                .toList().toMutableList()

            for (i in 0 until sideEffects.size) {
                sideEffects[i] = """${sideEffects[i]} ${frequencies.removeAt(0)}"""
            }

            result.add(SideEffect(header, sideEffects))
        }

        return result
    }

    private fun removeTags(sideEffect: String): String {
        return sideEffect.replace(Regex("<.*>"), "")
    }

    private fun columns(): Pair<List<String>, List<String>> {
        val sideEffects = row().first.split("<strong>").drop(1)

        val frequencies = row().second.split("<br>")
            .drop(1)
            .filter { frequency -> frequency.isNotEmpty() }
            .map { frequency -> removeTags(frequency) }
            .toList()

        return Pair(sideEffects, frequencies)
    }
}
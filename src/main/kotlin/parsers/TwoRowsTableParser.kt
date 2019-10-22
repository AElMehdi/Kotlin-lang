package parsers

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import domain.SideEffect
import domain.SideEffects
import org.jsoup.Jsoup.parse
import org.jsoup.nodes.Element
import shared.FileReader

object TwoRowsTableParser {
    private val mapper = jacksonObjectMapper()

    private const val TABLE_TAG = "table"

    fun htmlSideEffectsToJson(): String {
        return mapper.writeValueAsString(SideEffects(sideEffects = sideEffectsWithFrequencies()))
    }

    fun sideEffectsWithFrequencies(): List<SideEffect> {
        val result = mutableListOf<SideEffect>()

        val frequencies = columns().second.toMutableList()

        for (column in columns().first) {

            val headerAndSideEffects = column.split("</strong>")

            val header = headerAndSideEffects[0]

            val sideEffects = headerAndSideEffects[1].split("<br>")
                .filter(String::isNotEmpty)
                .map(this::removeTags)
                .toMutableList()

            for (i in 0 until sideEffects.size) {
                sideEffects[i] = """${sideEffects[i]} ${frequencies.removeAt(0)}"""
            }

            result.add(SideEffect(header, sideEffects))
        }

        return result
    }

    private fun columns(): Pair<List<String>, List<String>> {
        val sideEffects = sideEffectsAndFrequenciesFromRow().first.split("<strong>").drop(1)

        val frequencies = sideEffectsAndFrequenciesFromRow().second.split("<br>")
            .drop(1)
            .filter(String::isNotEmpty)
            .map(this::removeTags)
            .toList()

        return Pair(sideEffects, frequencies)
    }

    private fun sideEffectsAndFrequenciesFromRow(): Pair<String, String> {
        val contentWithoutTableHeader = parse(table()).select("tr")[1]

        val sideEffectsFomColumn = sideEffectsColumn(contentWithoutTableHeader)
        val frequenciesFromColumn = frequenciesFromColumn(contentWithoutTableHeader)

        return Pair(sideEffectsFomColumn, frequenciesFromColumn)
    }

    private fun frequenciesFromColumn(contentWithoutTableHeader: Element) =
        contentWithoutTableHeader.select("td")[1].outerHtml()

    private fun sideEffectsColumn(contentWithoutTableHeader: Element) =
        contentWithoutTableHeader.select("td")[0].outerHtml()

    fun table(): String {
        val htmlString = FileReader.readFile("../twoRowsColumnsTable.html")
        val table = parse(htmlString).getElementsByTag(TABLE_TAG)
        return table.outerHtml()
    }

    private fun removeTags(sideEffect: String): String {
        return sideEffect.replace(Regex("<.*>"), "")
    }
}

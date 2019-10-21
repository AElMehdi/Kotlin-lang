package parsers
import domain.SideEffect
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import parsers.TwoRowsTableParser.htmlSideEffectsToJson
import parsers.TwoRowsTableParser.sideEffectsWithFrequencies
import parsers.TwoRowsTableParser.table

class TwoRowsTableParserTest {

    @Test
    fun should_get_the_table_content() {
        assertThat(table()).contains("<table")
    }

    @Test
    fun should_return_side_effects_json_from_html() {
        assertThat(htmlSideEffectsToJson())
            .isEqualTo(this::class.java.getResource("../sideEffectsJson.json")
                .readText(Charsets.UTF_8))
    }

    @Test
    fun should_destructure_row_into_header_and_side_effects() {
        val firstRow = SideEffect(
            "Infections et infestations",
            listOf("Nasopharyngite Fréquent", "Rhinite Peu fréquent", "Cystite Peu fréquent")
        )

        val lastRow = SideEffect(
            "Troubles généraux et anomalies au site d'administration",
            listOf("Sensation de fatigue Peu fréquent", "Asthénie Peu fréquent")
        )

        assertThat(sideEffectsWithFrequencies())
            .hasSize(12)
            .contains(firstRow,lastRow)
    }
}

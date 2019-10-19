
import Main.header
import Main.htmlSideEffectsToJson
import Main.readFile
import Main.sideEffects
import Main.table
import domain.SideEffect
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun should_read_file_content() {
        assertThat(readFile()).isNotBlank()
    }

    @Test
    fun should_get_the_table_content() {
        assertThat(table()).contains("<table")
    }

    @Test
    fun should_get_title_from_a_row() {
        assertThat(header()).isEqualTo("Infections et infestations")
    }

    @Test
    fun should_return_side_effects_json_from_html() {
        assertThat(htmlSideEffectsToJson())
            .isEqualTo(MainKtTest::class.java.getResource("sideEffectsJson").readText(Charsets.UTF_8))
    }

    @Test
    fun should_destructure_row_into_header_and_side_effects() {
        assertThat(sideEffects())
            .hasSize(12)
            .contains(
                SideEffect("Infections et infestations",
                    listOf("Nasopharyngite Fréquent", "Rhinite Peu fréquent", "Cystite Peu fréquent")),
                SideEffect("Troubles généraux et anomalies au site d'administration",
                    listOf("Sensation de fatigue Peu fréquent", "Asthénie Peu fréquent")))
    }
}
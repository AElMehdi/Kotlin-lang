
import Main.htmlToSideEffectsJson
import Main.readFile
import Main.rows
import Main.sideEffect
import Main.table
import Main.title
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
    fun should_get_a_table_row() {
    }

    @Test
    fun should_get_title_from_a_row() {
        assertThat(title()).isEqualTo("Infections et infestations")
    }

    @Test
    fun should_return_side_effects_from_a_row() {
        assertThat(sideEffect()).isEqualTo("Nasopharyngite Fréquent")
    }

    @Test
    fun should_return_side_effect_from_html() {
        assertThat(htmlToSideEffectsJson())
            .isEqualTo("{\"title\":\"Infections et infestations\",\"sideEffect\":\"Nasopharyngite Fréquent\"}")
    }

    @Test
    fun should_return_side_effects_rows() {
        assertThat(rows()).hasSize(12)

    }
}

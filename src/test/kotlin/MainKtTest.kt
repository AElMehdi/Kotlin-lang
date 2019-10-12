import Main.htmlToSideEffectsJson
import Main.readFile
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MainKtTest {

    @Test
    fun should_read_file_content() {
        assertThat(readFile()).isNotBlank()
    }

    @Test
    fun should_parse_html_to_json() {
        val result = htmlToSideEffectsJson()

        assertThat(result).isEqualTo("{\"header\":\"My header\",\"content\":\"My content\"}")
    }
}

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun should_parse_html() {
        val expected = """Centered Heading
Centered paragraph."""

        val parsed = parse()

        assertThat(parsed).isEqualTo(expected)
    }
}

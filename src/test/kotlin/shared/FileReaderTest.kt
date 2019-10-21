package shared

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileReaderTest {
    @Test
    internal fun should_read_file_from_resource_folder() {
        assertThat(FileReader.readFile("../htmlContent.html"))
            .isNotBlank()
    }
}

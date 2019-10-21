
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

    @Test
    fun should_return_side_effect_from_html() {
        assertThat(htmlSideEffectsToJson())
            .isEqualTo("{\"section\":\"Effets Indésirables\",\"granularity\":\"Section\",\"sideEffects\":[{\"header\":\"Infections et infestations\",\"sideEffects\":[\"Nasopharyngite Fréquent\",\"Rhinite Peu fréquent\",\"Cystite Peu fréquent\"]},{\"header\":\"Affections du système immunitaire\",\"sideEffects\":[\"Hypersensibilité Peu fréquent\",\"Angioedème Peu fréquent\"]},{\"header\":\"Troubles du métabolisme et de la nutrition\",\"sideEffects\":[\"Hyperglycémie Peu fréquent\"]},{\"header\":\"Affections psychiatriques\",\"sideEffects\":[\"Insomnie Fréquent\"]},{\"header\":\"Affections du système nerveux\",\"sideEffects\":[\"Céphalée Fréquent\",\"Hypoesthésie Peu fréquent\"]},{\"header\":\"Affections cardiaques\",\"sideEffects\":[\"Fibrillation auriculaire Peu fréquent\",\"Palpitations Peu fréquent\"]},{\"header\":\"Affections respiratoires, thoraciques et médiastinales\",\"sideEffects\":[\"Congestion au niveau des sinus Peu fréquent\",\"Toux productive Peu fréquent\",\"Irritation de la gorge Peu fréquent\",\"Epistaxis Peu fréquent\",\"Bronchospasme paradoxal) Fréquence inconnue\"]},{\"header\":\"Affections gastro-intestinales\",\"sideEffects\":[\"Sécheresse buccale Fréquent\",\"Gastro-entérite Fréquent\",\"Dyspepsie Peu fréquent\",\"Caries dentaires Peu fréquent\"]},{\"header\":\"Affections de la peau et du tissu sous-cutané\",\"sideEffects\":[\"Eruption cutanée Peu fréquent\",\"Prurit Peu fréquent\"]},{\"header\":\"Affections musculo-squelettiques et systémiques\",\"sideEffects\":[\"Douleurs des extrémités Peu fréquent\",\"Douleur thoracique musculo-squelettique Peu fréquent\"]},{\"header\":\"Affections du rein et des voies urinaires\",\"sideEffects\":[\"Infection urinaire Fréquent\",\"Dysurie Peu fréquent\",\"Rétention urinaire Peu fréquent\"]},{\"header\":\"Troubles généraux et anomalies au site d'administration\",\"sideEffects\":[\"Sensation de fatigue Peu fréquent\",\"Asthénie Peu fréquent\"]}]}")
    }
}

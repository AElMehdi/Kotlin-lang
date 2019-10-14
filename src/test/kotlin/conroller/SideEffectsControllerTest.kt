package conroller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@ExtendWith(SpringExtension::class)
class SideEffectsControllerTest(@Autowired val mockMvc: MockMvc) {

    @Test
    fun should_greet() {
        mockMvc.perform(get("/greet"))
            .andExpect(status().isOk)
            .andExpect(content().string("Hello World"))
    }

}



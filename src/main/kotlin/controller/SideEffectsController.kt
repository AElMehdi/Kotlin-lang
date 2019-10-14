package controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SideEffectsController {

    @GetMapping("/greet")
    fun greet(): String {
        return "Hello World"
    }
}

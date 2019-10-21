package controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SideEffectsController {

    // TODO: Post the document content
    // Call from here the:
    // 1 Checker (Which document model to be parsed)
    // 2 The adequate parser
    // 3 (Persist) / return the parsed html content as JSON
    @GetMapping("/greet")
    fun greet(): String {
        return "Hello World"
    }
}

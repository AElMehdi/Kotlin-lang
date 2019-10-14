
import controller.SideEffectsController
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class ContextConfiguration {

    @Bean
    open fun sideEffectsController(): SideEffectsController {
        return SideEffectsController()
    }
}

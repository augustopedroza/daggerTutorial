import CommandRouter
import dagger.Component

@Component
interface CommandRouterFactory {
    fun router(): CommandRouter
}
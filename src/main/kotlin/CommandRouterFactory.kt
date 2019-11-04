import dagger.Component

@Component(modules = [HelloWorldModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
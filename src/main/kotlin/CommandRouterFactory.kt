import dagger.Component

@Component(modules = [HelloWorldModule::class, SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
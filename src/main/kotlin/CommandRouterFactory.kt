import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HelloWorldModule::class,
    LoginCommandModule::class,
    UserCommandsModules::class,
    SystemOutModule::class])
interface CommandRouterFactory {
    fun router(): CommandRouter
}
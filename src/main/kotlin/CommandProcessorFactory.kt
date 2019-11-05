import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [HelloWorldModule::class,
    LoginCommandModule::class,
    SystemOutModule::class,
    UserCommandsRouter.InstallationModule::class,
    AmountsModule::class])
interface CommandProcessorFactory {
    fun processor(): CommandProcessor
}
import dagger.Module
import dagger.Binds

@Module
interface HelloWorldModule {
    @Binds
    fun helloWorldCommand(command: HelloWorldCommand): Command
}
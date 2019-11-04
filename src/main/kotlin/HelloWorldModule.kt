import dagger.Module
import dagger.Binds
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface HelloWorldModule {
    @Binds
    @IntoMap
    @StringKey("hello")
    fun helloWorldCommand(command: HelloWorldCommand): Command
}
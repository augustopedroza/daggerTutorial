import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
interface LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    fun loginCommand(command: LoginCommand): Command
}
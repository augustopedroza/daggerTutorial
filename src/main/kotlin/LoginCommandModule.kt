import dagger.Binds
import dagger.BindsOptionalOf
import dagger.Module
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import Database.Account

@Module
interface LoginCommandModule {
    @Binds
    @IntoMap
    @StringKey("login")
    fun loginCommand(command: LoginCommand): Command

    @BindsOptionalOf
    fun optionalAccount(): Account
}
import dagger.Binds
import dagger.Module

@Module
interface LoginCommandModule {
    @Binds
    fun loginCommand(command: LoginCommand): Command
}

import dagger.multibindings.StringKey
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module

@Module
abstract class UserCommandsModule {
    @Binds
    @IntoMap
    @StringKey("deposit")
    internal abstract fun depositCommand(command: DepositCommand): Command

    @Binds
    @IntoMap
    @StringKey("withdraw")
    internal abstract fun withdrawCommand(command: WithdrawCommand): Command
    @Binds
    @IntoMap
    @StringKey("logout")
    internal abstract fun logoutCommand(command: LogoutCommand): Command
}
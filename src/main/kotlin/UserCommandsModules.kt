
import dagger.multibindings.StringKey
import dagger.multibindings.IntoMap
import dagger.Binds
import dagger.Module

@Module
abstract class UserCommandsModules {
    @Binds
    @IntoMap
    @StringKey("deposit")
    internal abstract fun depositCommand(command: DepositCommand): Command
}
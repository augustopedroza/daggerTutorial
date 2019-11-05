import dagger.Module
import dagger.Provides
import java.math.BigDecimal

@Module
class AmountsModule {
    @Provides
    @MinimumBalance
    fun minimumBalance(): BigDecimal {
        return BigDecimal.ZERO
    }

    @Provides
    @MaximumWithdrawal
    fun maximumWithdrawal(): BigDecimal {
        return BigDecimal(1000)
    }
}
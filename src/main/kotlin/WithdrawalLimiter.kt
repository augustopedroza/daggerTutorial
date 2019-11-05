import java.math.BigDecimal
import javax.inject.Inject

@PerSession
class WithdrawalLimiter @Inject constructor(@MaximumWithdrawal maximumWithdrawal: BigDecimal) {
    var remainingWithdrawalLimit: BigDecimal = maximumWithdrawal

    fun recordDeposit(amount: BigDecimal) {
        remainingWithdrawalLimit += amount
    }

    fun recordWithdrawal(amount: BigDecimal) {
        remainingWithdrawalLimit -= amount
    }
}
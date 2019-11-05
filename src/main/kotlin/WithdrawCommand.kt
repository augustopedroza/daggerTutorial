import javax.inject.Inject
import Database.Account
import java.math.BigDecimal

class WithdrawCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Account,
    @MinimumBalance private val minimumBalance: BigDecimal,
    private var withdrawalLimiter: WithdrawalLimiter
) : BigDecimalCommand(outputter) {

    override fun handleAmount(amount: BigDecimal) {
        val remainingWithdrawalLimit = withdrawalLimiter.remainingWithdrawalLimit
        if (amount > remainingWithdrawalLimit) {
            outputter.output("you may not withdraw $amount; you may withdraw " +
                    "$remainingWithdrawalLimit more in this session")
            return
        }

        val newBalance = account.balance.subtract(amount)
        if (newBalance < minimumBalance) {
            outputter.output("you don't have sufficient funds to withdraw $amount. " +
                    "your balance is %s and the minimum balance is ${account.balance}")
        } else {
            account.withdraw(amount)
            withdrawalLimiter.recordWithdrawal(amount)
            outputter.output("your new balance is: " + account.balance)
        }
    }
}
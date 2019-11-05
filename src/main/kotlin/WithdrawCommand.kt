import javax.inject.Inject
import Database.Account
import java.math.BigDecimal

class WithdrawCommand @Inject constructor(
    private val outputter: Outputter,
    private val account: Account,
    @MinimumBalance private val minimumBalance: BigDecimal,
    @MaximumWithdrawal private val maximumWithdrawal: BigDecimal
) : BigDecimalCommand(outputter) {
    override fun handleAmount(amount: BigDecimal) {
        if (amount > maximumWithdrawal) {
            outputter.output("you may not withdraw $amount; you may withdraw $maximumWithdrawal more in this session")
            return
        }

        val newBalance = account.balance.subtract(amount)
        if (newBalance >= minimumBalance) {
            account.withdraw(amount)
            outputter.output("your new balance is: " + account.balance)
        } else {
            outputter.output(
                "you don't have sufficient funds to withdraw $amount." +
                        " Your balance is ${account.balance} and the minimum balance is $minimumBalance"
            )
        }
    }
}
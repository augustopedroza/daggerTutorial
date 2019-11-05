import Command.Result
import java.math.BigDecimal

abstract class BigDecimalCommand(private val outputter: Outputter): SingleArgCommand() {
     override fun handleArg(arg: String): Result {
        val amount = tryParse(arg)
         when {
             amount == null -> outputter.output("$arg is not a valid number")
             amount.signum() <= 0 -> outputter.output("amount must be positive")
             else -> handleAmount(amount)
         }
        return Result.handled()
    }

    private fun tryParse(arg: String): BigDecimal? {
        return try {
            BigDecimal(arg)
        } catch (e: NumberFormatException) {
            null
        }
    }

    /** Handles the given (positive) `amount` of money.  */
    protected abstract fun handleAmount(amount: BigDecimal)
}
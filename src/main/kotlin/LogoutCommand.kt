import Command.Result
import Database.Account
import javax.inject.Inject

class LogoutCommand @Inject constructor(private val outputter: Outputter, private val account: Account) : Command {
    override fun handleInput(input: List<String>): Result = if (input.isEmpty()) {
        outputter.output("logged out ${account.username}")
        Result.inputCompleted()
    } else {
        Result.invalid()
    }
}
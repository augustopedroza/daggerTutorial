import javax.inject.Inject
import Command.Result
import Database.Account
import java.util.*

class LoginCommand @Inject constructor(private val database: Database,
                                       private val outputter: Outputter,
                                       private val userCommandsRouterFactory: UserCommandsRouter.Factory,
                                       private val account: Optional<Account>
): SingleArgCommand() {

    public override fun handleArg(username: String): Result {
        if (account.isPresent) {
            val loggedInUser = account.get().username
            outputter.output("$loggedInUser is already logged in")
            if (loggedInUser != username) {
                outputter.output("run `logout` first before trying to log in another user")
            }
            return Result.handled();
        }

        val account = database.getAccount(username)
        outputter.output("$username is logged in with balance ${account.balance}")
        return Result.enterNestedCommandSet(
            userCommandsRouterFactory.create(account).router())
    }
}
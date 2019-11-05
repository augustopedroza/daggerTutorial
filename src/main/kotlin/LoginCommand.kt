import javax.inject.Inject
import Command.Result

class LoginCommand @Inject constructor(private val database: Database,
                                       private val outputter: Outputter,
                                       private val userCommandsRouterFactory: UserCommandsRouter.Factory): SingleArgCommand() {

    public override fun handleArg(username: String): Result {
        val account = database.getAccount(username)
        outputter.output("$username is logged in with balance ${account.balance}")
        return Result.enterNestedCommandSet(
            userCommandsRouterFactory.create(account).router())
    }
}
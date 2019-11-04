import Command.Status
import javax.inject.Inject

class LoginCommand @Inject constructor(private val database: Database, private val outputter: Outputter): SingleArgCommand() {

    public override fun handleArg(username: String): Status {
        val account = database.getAccount(username)
        outputter.output("$username is logged in with balance ${account.balance()}")
        return Status.HANDLED
    }
}
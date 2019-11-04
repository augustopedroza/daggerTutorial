import Command.Status
import javax.inject.Inject

class LoginCommand @Inject constructor(private val outputter: Outputter): SingleArgCommand() {

    public override fun handleArg(username: String): Status {
        outputter.output("$username is logged in.")
        return Status.HANDLED
    }
}
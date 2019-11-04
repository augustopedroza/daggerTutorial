import javax.inject.Inject
import Command.*

class HelloWorldCommand @Inject constructor(private var outputter: Outputter): Command {
    override val key: String = "hello"

    override fun handleInput(input: List<String>): Status {
        if (input.isNotEmpty()) {
            return Status.INVALID;
        }
        outputter.output("world!");
        return Status.HANDLED;
    }
}
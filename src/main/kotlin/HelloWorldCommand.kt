import javax.inject.Inject
import Command.*

class HelloWorldCommand @Inject constructor(): Command {
    override val key: String
        get() = "hello"

    override fun handleInput(input: List<String>): Status {
        if (input.isNotEmpty()) {
            return Status.INVALID;
        }
        println("world!");
        return Status.HANDLED;
    }
}
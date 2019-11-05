import javax.inject.Inject
import Command.Result

class HelloWorldCommand @Inject constructor(private var outputter: Outputter): Command {

    override fun handleInput(input: List<String>): Result {
        if (input.isNotEmpty()) {
            return Result.invalid();
        }
        outputter.output("world!");
        return Result.handled();
    }
}
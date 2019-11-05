import Command.*
import javax.inject.Inject

class CommandRouter @Inject constructor(private var commands: MutableMap<String, Command>) {

    fun route(input: String): Result {
        val splitInput = input.split(Regex("\\s+"))
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }
        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val result = command.handleInput(splitInput.subList(1, splitInput.size))
        if (result.status == Status.INVALID) {
            println("$commandKey: invalid arguments")
        }
        return result
    }

    private fun invalidCommand(input: String): Result {
        println("couldn't understand $input. please try again.")
        return Result.invalid();
    }
}

import Command.*
import javax.inject.Inject

class CommandRouter @Inject constructor() {
    private val commands = emptyMap<String, Command>()

    fun route(input: String): Status {
        val splitInput = input.split("\\s+")
        if (splitInput.isEmpty()) {
            return invalidCommand(input)
        }
        val commandKey = splitInput[0]
        val command = commands[commandKey] ?: return invalidCommand(input)

        val status =
        command.handleInput(splitInput.subList(1, splitInput.size));
        if (status == Status.INVALID) {
            println("$commandKey: invalid arguments");
        }
        return status;

    }

    private fun invalidCommand(input: String): Command.Status {
        println("couldn't understand $input. please try again.");
        return Status.INVALID;
    }
}

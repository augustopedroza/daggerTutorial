import Command.Result

abstract class SingleArgCommand: Command {
    override fun handleInput(input: List<String>): Result {
        return if (input.size == 1) handleArg(input[0]) else Result.invalid()
    }

    /** Handles the single argument to the command.  */
    protected abstract fun handleArg(arg: String): Result
}
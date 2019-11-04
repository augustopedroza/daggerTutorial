import Command.Status

abstract class SingleArgCommand: Command {
    override fun handleInput(input: List<String>): Status {
        return if (input.size == 1) handleArg(input[0]) else Status.INVALID
    }

    /** Handles the single argument to the command.  */
    protected abstract fun handleArg(arg: String): Status
}

interface Command {

    fun handleInput(input: List<String>): Result

    class Result(val status: Status, val nestedCommandRouter: CommandRouter?) {

        companion object {
            fun invalid(): Result {
                return Result(Status.INVALID, null)
            }

            fun handled(): Result {
                return Result(Status.HANDLED, null)
            }

            fun inputCompleted(): Result {
                return Result(Status.INPUT_COMPLETED, null)
            }
            fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result {
                return Result(Status.HANDLED, nestedCommandRouter)
            }
        }
    }
    enum class Status {
        INVALID,
        HANDLED,
        INPUT_COMPLETED
    }
}
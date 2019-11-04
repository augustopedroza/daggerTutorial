interface Command {
    val key: String

    fun handleInput(input: List<String>): Status

    enum class Status {
        INVALID,
        HANDLED
    }
}
interface Command {
    val key: String

    fun handleInput(inputs: List<String>): Status

    enum class Status {
        INVALID,
        HANDLED
    }
}
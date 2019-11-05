import java.util.ArrayDeque
import javax.inject.Inject
import javax.inject.Singleton
import Command.Status


@Singleton
class CommandProcessor @Inject constructor(firstCommandRouter: CommandRouter) {
    private val commandRouterStack = ArrayDeque<CommandRouter>()

    init {
        commandRouterStack.push(firstCommandRouter)
    }

    fun process(input: String): Status {
        val result = commandRouterStack.peek().route(input)
        if (Status.INPUT_COMPLETED == result.status) {
            commandRouterStack.pop()
            return if (commandRouterStack.isEmpty())
                Status.INPUT_COMPLETED
            else
                Status.HANDLED
        }

        result.nestedCommandRouter?.let { commandRouterStack.push(it) }
        return result.status
    }
}
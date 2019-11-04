import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val commandRouterFactory = DaggerCommandRouterFactory.create()
    val commandRouter = commandRouterFactory.router()
    while (scanner.hasNextLine()) {
        commandRouter.route(scanner.nextLine())
    }
}
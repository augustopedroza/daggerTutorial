import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val commandRouter = CommandRouter()

    while (scanner.hasNextLine()) {
        commandRouter.route(scanner.nextLine())
    }
}
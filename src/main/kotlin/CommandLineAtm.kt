import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val commandProcessor = DaggerCommandProcessorFactory.create().processor()
    while (scanner.hasNextLine()) {
        commandProcessor.process(scanner.nextLine())
    }
}
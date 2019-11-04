import dagger.Module
import dagger.Provides

@Module
class SystemOutModule {
    @Provides
    fun textOutputter() = object : Outputter {
        override fun output(message: String) {
            println(message)
        }
    }
}

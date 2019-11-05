import javax.inject.Qualifier

@Target(AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.PROPERTY)
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
internal annotation class MinimumBalance
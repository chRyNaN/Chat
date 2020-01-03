enum class Dependencies(
    override val library: String,
    override val version: String
) : Dependency {

    KOTLIN_COMMON(library = "org.jetbrains.kotlin:kotlin-stdlib-common", version = "1.3.61"),
    KOTLIN_COROUTINES_COMMON(library = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common", version = "1.3.3"),
    KOTLIN_JVM(library = "org.jetbrains.kotlin:kotlin-stdlib", version = "1.3.61"),
    KOTLIN_COROUTINES_JVM(library = "org.jetbrains.kotlinx:kotlinx-coroutines-core", version = "1.3.3"),
    JAVA_INJECT(library = "javax.inject:javax.inject", version = "1"),
    AAAAH_CORE(library = "com.chrynan:aaaah-core", version = "0.3.3")
}
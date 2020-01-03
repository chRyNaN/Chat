interface Dependency {

    val library: String

    val version: String
}

val Dependency.dependency: String
    get() = "$library:$version"
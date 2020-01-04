interface Dependency {

    val path: String

    val version: String
}

val Dependency.dependency: String
    get() = "$path:$version"

val Dependency.pom: String
    get() = "$path:$version@pom"
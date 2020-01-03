interface Module {

    val path: String
}

val Module.dependency: String
    get() = ":$path"
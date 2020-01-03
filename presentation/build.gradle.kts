plugins {
    kotlin("multiplatform")
    id("maven-publish")
}

group = Project.GROUP
version = Project.APP_VERSION

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                internal(PresentationModuleDependencies.KOTLIN_COMMON)
                external(PresentationModuleDependencies.AAAAH_CORE)

                external(Project.Module.COMMON)
            }
        }
        val jvmMain by getting {
            dependencies {
                internal(PresentationModuleDependencies.KOTLIN_JVM)
            }
        }
    }
}

configurations {
    //compileClasspath
}

// TODO This should be in the buildSrc directory but Gradle is a Disaster and so is the Kotlin Gradle DSL plugin and
//  you can't depend on it to add these extension functions. So now the have to be duplicated in every module.
fun org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler.external(module: Module): org.gradle.api.artifacts.Dependency? {
    return api(project(module.dependency))
}

fun org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler.internal(module: Module): org.gradle.api.artifacts.Dependency? {
    return implementation(project(module.dependency))
}

fun org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler.external(dependency: Dependency): org.gradle.api.artifacts.Dependency? {
    return api(dependency.dependency)
}

fun org.jetbrains.kotlin.gradle.plugin.KotlinDependencyHandler.internal(dependency: Dependency): org.gradle.api.artifacts.Dependency? {
    return implementation(dependency.dependency)
}
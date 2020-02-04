group = Project.GROUP
version = Project.APP_VERSION

buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.5.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.61")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
        maven {
            url = uri("https://maven.pkg.github.com/chRyNaN/aaaah")
            credentials {
                username = project.findProperty("gpr.user") as? String?
                password = project.findProperty("gpr.key") as? String?
            }
        }
        maven {
            url = uri("https://dl.bintray.com/chrynan/chrynan")
        }
        maven {
            url = uri("https://maven.pkg.github.com/chRyNaN/logger")
            credentials {
                username = project.findProperty("gpr.user") as? String?
                password = project.findProperty("gpr.key") as? String?
            }
        }
    }

    tasks.withType(org.jetbrains.kotlin.gradle.tasks.KotlinCompile::class).all {
        kotlinOptions {
            freeCompilerArgs = listOf(
                "-Xuse-experimental=kotlin.Experimental",
                "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi"
            )
            jvmTarget = "1.8"
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
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
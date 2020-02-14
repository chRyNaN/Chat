plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
}

android {
    compileSdkVersion(Project.Android.COMPILE_SDK_VERSION)

    defaultConfig {
        applicationId = Project.APP_ID
        minSdkVersion(Project.Android.MIN_SDK_VERSION)
        targetSdkVersion(Project.Android.TARGET_SDK_VERSION)
        versionCode = Project.APP_VERSION_CODE
        versionName = Project.APP_VERSION

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    packagingOptions {
        exclude("META-INF/kotlinx-coroutines-core.kotlin_module")
        exclude("META-INF/core.kotlin_module")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    //kotlinOptions {
    //    jvmTarget = "1.8"
    //}
}

repositories {
    google()
    jcenter()
    maven { url = uri("https://jitpack.io") }
    maven {
        url = uri("https://dl.bintray.com/chrynan/chrynan")
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Android Support
    internal(AndroidModuleDependencies.ANDROID_APP_COMPAT)

    // Android UI Components
    internal(AndroidModuleDependencies.ANDROID_CONSTRAINT_LAYOUT)
    internal(AndroidModuleDependencies.ANDROID_RECYCLER_VIEW)
    internal(AndroidModuleDependencies.ANDROID_MATERIAL_DESIGN)
    internal(AndroidModuleDependencies.ANDROID_CARD_VIEW)
    internal(AndroidModuleDependencies.ANDROID_COORDINATOR_LAYOUT)

    // Circle Image View
    internal(AndroidModuleDependencies.ANDROID_CIRCLE_VIEW)

    // Coroutines
    internal(AndroidModuleDependencies.KOTLIN_COROUTINES_JVM)
    internal(AndroidModuleDependencies.KOTLIN_COROUTINES_ANDORID)

    // Android Architecture Components
    internal(AndroidModuleDependencies.ANDROID_ARCH_COMMON)
    internal(AndroidModuleDependencies.ANDROID_ARCH_RUNTIME)
    internal(AndroidModuleDependencies.ANDROID_ARCH_LIFECYCLE)
    internal(AndroidModuleDependencies.ANDROID_ARCH_LIFECYCLE_EXT)
    internal(AndroidModuleDependencies.ANDROID_ARCH_LIFECYCLE_VIEWMODEL)
    internal(AndroidModuleDependencies.ANDROID_ARCH_LIFECYCLE_RUNTIME)

    // Image Loading - Coil
    internal(AndroidModuleDependencies.ANDROID_COIL)

    // Panning Image View
    internal(AndroidModuleDependencies.PHOTO_VIEW)

    // Common Presentation Module
    internal(Project.Module.PRESENTATION)
    internal(Project.Module.COMMON)

    // RecyclerView Library - Aaaah
    internal(AndroidModuleDependencies.AAAAH_LIBRARY)
    internal(AndroidModuleDependencies.AAAAH_ANNOTATION)
    kapt(AndroidModuleDependencies.AAAAH_COMPILER)

    // Dependency Injection - Dagger
    kapt(AndroidModuleDependencies.DAGGER_COMPILER)
    kapt(AndroidModuleDependencies.DAGGER_ANDROID_PROCESSOR)
    internal(AndroidModuleDependencies.DAGGER_CORE)
    internal(AndroidModuleDependencies.DAGGER_ANDROID_SUPPORT)

    // Video Player - ExoPlayer
    internal(AndroidModuleDependencies.ANDROID_EXO_PLAYER)

    // JSON - Klaxon
    internal(AndroidModuleDependencies.KLAXON)

    // Logging
    internal(AndroidModuleDependencies.LOGGER_ANDROID)
    internal(AndroidModuleDependencies.LOGGER_ANDROID_TIMBER)
}

androidExtensions {
    isExperimental = true
}

// TODO This should be in the buildSrc directory but Gradle is a Disaster and so is the Kotlin Gradle DSL plugin and
//  you can't depend on it to add these extension functions. So now the have to be duplicated in every module.
fun DependencyHandlerScope.external(module: Module): org.gradle.api.artifacts.Dependency? {
    return api(project(module.dependency))
}

fun DependencyHandlerScope.internal(module: Module): org.gradle.api.artifacts.Dependency? {
    return implementation(project(module.dependency))
}

fun DependencyHandlerScope.external(dependency: Dependency): org.gradle.api.artifacts.Dependency? {
    return api(dependency.dependency)
}

fun DependencyHandlerScope.internal(dependency: Dependency): org.gradle.api.artifacts.Dependency? {
    return implementation(dependency.dependency)
}

fun DependencyHandlerScope.kapt(dependency: Dependency): org.gradle.api.artifacts.Dependency? {
    return kapt(dependency.dependency)
}
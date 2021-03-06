@file:Suppress("OPT_IN_IS_NOT_ENABLED")

import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.plugin.use.PluginDependenciesSpec

fun PluginDependenciesSpec.installPlugins(
    isPresentation: Boolean = false,
    isDFM: Boolean = false,
    hilt: Boolean = false,
) {
    if (!isPresentation && !isDFM) {
        id("com.android.library")
    }
    if (isDFM) {
        id("com.android.dynamic-feature")
    }
    id("kotlin-android")
    id("kotlin-kapt")
    if (!isDFM && hilt) {
        id("dagger.hilt.android.plugin")
    }
}

@OptIn(
    AndroidTestImplementation::class, // Dependencies.Test.ComposeUI
    DebugImplementation::class, // Dependencies.Test.ComposeDebug
    TestRuntimeOnly::class // Dependencies.Test.JunitVintageEngine
)
fun DependencyHandler.installDependencies(
    excludeSharedAndroidModule: Boolean = false,
    isSharedTestModule: Boolean = false,
    orbit: Boolean = false,
    hilt: Boolean = false,
    compose: Boolean = false,
    test: Boolean = false,
) {
    if (orbit) {
        implementation(Dependencies.Orbit.Main)
    }
    if (!excludeSharedAndroidModule) {
        projectImplementation(ProjectConstants.SharedAndroid)
    }
    if (hilt) {
        implementation(Dependencies.Jetpack.Hilt)
        kapt(Dependencies.Compiler.Hilt)
    }
    if (compose) {
        Dependencies.Compose.forEach(::implementation)
        debugImplementation(Dependencies.Debug.Compose)
        projectImplementation(ProjectConstants.SharedCompose)
    }
    if (test) {
        if (orbit) {
            testImplementation(Dependencies.Orbit.Test)
        }
        if (compose) {
            androidTestImplementation(Dependencies.Test.ComposeUI)
            debugImplementation(Dependencies.Test.ComposeDebug)
        }
        if (!isSharedTestModule) {
            projectImplementation(ProjectConstants.SharedTest)
        }
        Dependencies.Test.Local.forEach(::testImplementation)
        testRuntimeOnly(Dependencies.Test.JunitVintageEngine)
    }
}

@Suppress(
    "OPT_IN_IS_NOT_ENABLED", // OptIn usage
    "UNCHECKED_CAST" // Collection<*> as Collection<Any>
)
@OptIn(ExperimentalStdlibApi::class) // buildList
// only List or String or platform enters.
fun List<*>.dependenciesFlatten() = buildList {
    this@dependenciesFlatten.forEach { dependency ->
        checkNotNull(dependency) {
            "dependency $dependency is null."
        }
        when (dependency) {
            is Collection<*> -> addAll(dependency as Collection<Any>)
            else -> add(dependency)
        }
    }
}

// should public (using at other gradle files)
fun DependencyHandler.projectImplementation(path: String) {
    implementation(project(path))
}

private fun DependencyHandler.implementation(dependencyNotation: Any) {
    add("implementation", dependencyNotation)
}

private fun DependencyHandler.debugImplementation(dependencyNotation: Any) {
    add("debugImplementation", dependencyNotation)
}

private fun DependencyHandler.testImplementation(dependencyNotation: Any) {
    add("testImplementation", dependencyNotation)
}

private fun DependencyHandler.testRuntimeOnly(dependencyNotation: Any) {
    add("testRuntimeOnly", dependencyNotation)
}

private fun DependencyHandler.androidTestImplementation(dependencyNotation: Any) {
    add("androidTestImplementation", dependencyNotation)
}

private fun DependencyHandler.kapt(dependencyNotation: Any) {
    add("kapt", dependencyNotation)
}

private fun DependencyHandler.project(path: String) =
    project(mapOf(Pair("path", path))) as ProjectDependency

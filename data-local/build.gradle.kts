@file:Suppress("OPT_IN_IS_NOT_ENABLED")

/*
* ApiLibrary © 2022 Ji Sungbin. all rights reserved.
* ApiLibrary license is under the MIT.
*
* [build.gradle.kts] created by Ji Sungbin on 22. 6. 24. 오전 8:50
*
* Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
*/

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.google.devtools.ksp") version Versions.Ksp
}

kotlin {
    sourceSets.main {
        kotlin.srcDir("build/generated/ksp/main/kotlin")
    }
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

android {
    namespace = "land.sungbin.apilibrary.data.local"
}

@OptIn(Ksp::class) // Dependencies.Compiler.Room
dependencies {
    val dependencies = listOf(
        Dependencies.Ksp,
        Dependencies.Jetpack.Room,
    )
    dependencies.forEach(::implementation)

    val projects = listOf(
        ProjectConstants.Domain,
        ProjectConstants.SharedDomain
    )
    projects.forEach(::projectImplementation)

    ksp(Dependencies.Compiler.Room)

    installDependencies(
        excludeSharedAndroidModule = true,
        test = true
    )
}

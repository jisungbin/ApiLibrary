/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [build.gradle.kts] created by Ji Sungbin on 22. 6. 22. 오전 3:12
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
    namespace = "land.sungbin.apilibrary.data"
}

dependencies {
    val dependencies = listOf(
        Dependencies.Ksp,
        Dependencies.Jackson,
        Dependencies.Network,
        Dependencies.Jetpack.Room,
    ).dependenciesFlatten()
    dependencies.forEach(::implementation)

    val projects = listOf(
        ProjectConstants.Domain,
        ProjectConstants.SharedDomain
    )
    projects.forEach(::projectImplementation)

    val ksps = listOf(
        Dependencies.Compiler.RoomKsp
    )
    ksps.forEach(::ksp)

    installDependencies(
        excludeSharedAndroidModule = true,
        test = true
    )
}

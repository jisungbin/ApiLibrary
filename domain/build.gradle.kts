/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [build.gradle.kts] created by Ji Sungbin on 22. 6. 22. 오전 3:11
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("org.jetbrains.dokka") version Versions.BuildUtil.Dokka
}

android {
    namespace = "land.sungbin.apilibrary.domain"
}

dependencies {
    val projects = listOf(
        ProjectConstants.SharedDomain
    )
    projects.forEach(::projectImplementation)
}

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [build.gradle.kts] created by Ji Sungbin on 22. 6. 22. 오전 3:13
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "land.sungbin.apilibrary.shared.android"
}

dependencies {
    val apis = listOf(
        Dependencies.Ktx,
        Dependencies.Jetpack.DataStore,
        Dependencies.Jetpack.ProfileInstaller,
        project(ProjectConstants.Domain),
        project(ProjectConstants.SharedDomain)
    ).dependenciesFlatten()
    apis.forEach(::api)
}

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [build.gradle.kts] created by Ji Sungbin on 22. 6. 22. 오전 3:13
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

plugins {
    installPlugins(
        isPresentation = true,
        isDFM = false,
        hilt = true,
    )
    id("com.android.application")
    id("com.google.android.gms.oss-licenses-plugin")
}

android {
    namespace = "land.sungbin.apilibrary"

    defaultConfig {
        versionCode = ApplicationConstants.versionCode
        versionName = ApplicationConstants.versionName
    }

    buildTypes {
        debug {
            aaptOptions.cruncherEnabled = false // png optimization (default: true)
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Compose.Main
    }
}

dependencies {
    val features = listOf(
        ProjectConstants.Data,
        ProjectConstants.SharedAndroid,
    )
    features.forEach(::projectImplementation)

    val dependencies = listOf(
        Dependencies.Ui,
        Dependencies.Analytics,
        Dependencies.EachUtil.Erratum,
    ).dependenciesFlatten()
    dependencies.forEach(::implementation)

    debugImplementation(Dependencies.Debug.LeakCanary)
    installDependencies(
        excludeSharedAndroidModule = false,
        orbit = true,
        hilt = true,
        compose = true,
        test = true
    )
}

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
    jacoco
}

jacoco {
    toolVersion = Versions.Test.JaCoCo
}

tasks.withType<JacocoReport> {
    reports {
        html.required.set(true)
        html.outputLocation.set(layout.projectDirectory.dir("../documents/coverage/jacoco/html"))
        xml.required.set(true) // codecov depends on xml format report
        xml.outputLocation.set(layout.projectDirectory.file("../documents/coverage/jacoco/report.xml"))
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

android {
    namespace = "land.sungbin.androidprojecttemplate.domain"
}

dependencies {
    val projects = listOf(
        ProjectConstants.SharedDomain
    )
    projects.forEach(::projectImplementation)

    Dependencies.Test.Local.forEach(::testImplementation)
}

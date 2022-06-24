/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [settings.gradle.kts] created by Ji Sungbin on 22. 6. 22. 오전 3:13
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

rootProject.name = "ApiLibrary"
include(
    ":domain",
    ":data-local",
    ":data-remote",
    ":presentation",
    ":shared:test",
    ":shared:domain",
    ":shared:compose",
    ":shared:android",
)

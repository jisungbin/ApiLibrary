/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [CompositionLocal.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:15
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.compose.extension

import androidx.activity.ComponentActivity
import androidx.compose.runtime.staticCompositionLocalOf
import land.sungbin.apilibrary.shared.compose.optin.LocalActivityUsageApi

@LocalActivityUsageApi
val LocalActivity = staticCompositionLocalOf<ComponentActivity> {
    noLocalProvidedFor("LocalActivity")
}

@Suppress("SameParameterValue")
private fun noLocalProvidedFor(name: String): Nothing {
    error("CompositionLocal $name not present")
}

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [throwable.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:22
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.domain.extension

import io.github.jisungbin.logeukes.BuildConfig

fun Throwable.toMessage() = when (BuildConfig.DEBUG) {
    true -> message?.trim() ?: "Error message is null."
    else ->
        "A temporary error has occurred.\n" +
            "Please try again in a few minutes."
}

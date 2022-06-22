/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [flow.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:22
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.domain.extension

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch

fun <T> Flow<T>.defaultCatch(
    name: String? = null,
    action: (exception: IllegalStateException) -> Unit,
) = catch { cause ->
    val exception =
        IllegalStateException("${name ?: cause.tag} flow collect exception: ${cause.message}")
    action(exception)
}

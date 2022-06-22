/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [runIf.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:22
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.domain.extension

inline fun <T> T.runIf(condition: Boolean, run: T.(value: T) -> T) = if (condition) {
    run(this)
} else this

inline fun <T> T.runIf(conditionBuilder: (T) -> Boolean, run: T.(value: T) -> T) = runIf(
    condition = conditionBuilder(this),
    run = run
)

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [string.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:22
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.domain.extension

fun String.convertNullableString() = if (this == "null") null else this

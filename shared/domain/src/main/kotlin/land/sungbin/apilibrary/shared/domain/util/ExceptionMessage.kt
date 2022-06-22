/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [ExceptionMessage.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:24
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.domain.util

fun requireFieldNullMessage(fieldName: String) = "Require `$fieldName` field is null."
fun notAllowedValueMessage(value: Any) = "$value is not allowed here."
fun unknownResultMessage(result: Any) = "Unknown result: $result"

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [EntriesItem.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.domain.model

data class ApiItem(
    val description: String,
    val category: String,
    val https: Boolean,
    val authType: String,
    val apiName: String,
    val cors: Boolean,
    val link: String
)

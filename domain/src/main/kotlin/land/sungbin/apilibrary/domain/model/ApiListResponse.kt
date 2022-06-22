/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [ApiListResponse.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.domain.model

data class ApiListResponse(
    val entries: List<ApiItem>,
    val count: Int
)

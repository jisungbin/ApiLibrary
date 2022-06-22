/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [ApiListResponse.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.model

import com.fasterxml.jackson.annotation.JsonProperty
import land.sungbin.apilibrary.domain.model.ApiItem

data class ApiListResponse(
    @field:JsonProperty("entries")
    val entries: List<ApiItem?>? = null,

    @field:JsonProperty("count")
    val count: Int? = null
)

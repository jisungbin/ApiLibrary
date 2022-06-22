/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [EntriesItem.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.model

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiItem(
    @field:JsonProperty("Description")
    val description: String? = null,

    @field:JsonProperty("Category")
    val category: String? = null,

    @field:JsonProperty("HTTPS")
    val https: Boolean? = null,

    @field:JsonProperty("Auth")
    val auth: String? = null,

    @field:JsonProperty("API")
    val api: String? = null,

    @field:JsonProperty("Cors")
    val cors: String? = null,

    @field:JsonProperty("Link")
    val link: String? = null
)

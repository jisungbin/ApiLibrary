/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [mapper.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:15
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.mapper

import land.sungbin.apilibrary.data.model.ApiItemResponse
import land.sungbin.apilibrary.data.model.PublicApiResponse
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.domain.model.PublicApi
import land.sungbin.apilibrary.shared.domain.util.requireFieldNullMessage

internal fun PublicApiResponse.toDomain() = PublicApi(
    entries = requireNotNull(this.entries) {
        requireFieldNullMessage("entries")
    }.toDomain(),
    count = requireNotNull(this.count) {
        requireFieldNullMessage("PublicApiResponse.count")
    }
)

private fun List<ApiItemResponse?>.toDomain() = map { item ->
    requireNotNull(item) {
        requireFieldNullMessage("ApiItem")
    }
    ApiItem(
        description = requireNotNull(item.description) {
            requireFieldNullMessage("ApiItem.category")
        },
        category = requireNotNull(item.category) {
            requireFieldNullMessage("ApiItem.category")
        },
        https = requireNotNull(item.https) {
            requireFieldNullMessage("ApiItem.https")
        },
        authType = requireNotNull(item.auth) {
            requireFieldNullMessage("ApiItem.auth")
        },
        apiName = requireNotNull(item.api) {
            requireFieldNullMessage("ApiItem.api")
        },
        cors = requireNotNull(item.cors) {
            requireFieldNullMessage("ApiItem.cors")
        } == "yes",
        link = requireNotNull(item.link) {
            requireFieldNullMessage("ApiItem.link")
        }
    )
}

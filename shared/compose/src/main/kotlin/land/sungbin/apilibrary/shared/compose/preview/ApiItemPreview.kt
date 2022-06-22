/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [ApiItemPreview.kt] created by Ji Sungbin on 22. 6. 23. 오전 1:36
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.compose.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import land.sungbin.apilibrary.domain.model.ApiItem
import kotlin.random.Random

class ApiItemSinglePreview : PreviewParameterProvider<ApiItem> {
    override val values = sequenceOf(
        ApiItem(
            description = "This is a description.",
            category = "Category",
            https = Random.nextBoolean(),
            authType = "apiKey",
            apiName = "api",
            cors = Random.nextBoolean(),
            link = "https://api.github.com/users/jisungbin",
        )
    )
}

class ApiItemMultiPreview : PreviewParameterProvider<List<ApiItem>> {
    override val values = sequenceOf(
        List(10) { index ->
            ApiItem(
                description = "This is a $index index description.",
                category = "Category",
                https = Random.nextBoolean(),
                authType = "apiKey",
                apiName = "api",
                cors = Random.nextBoolean(),
                link = "https://api.github.com/users/jisungbin",
            )
        }
    )
}

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
import land.sungbin.apilibrary.shared.domain.extension.runIf
import kotlin.random.Random

private val PreviewApiItem
    get() = ApiItem(
        description = "This is a description.",
        category = "category",
        https = Random.nextBoolean(),
        authType = "apiKey",
        apiName = "api - ${
        Random.nextInt().runIf(
            conditionBuilder = { number -> number < 0 },
            run = { number -> number * -1 }
        )
        }",
        cors = Random.nextBoolean(),
        link = "https://api.github.com/users/jisungbin",
    )

class ApiItemSinglePreview : PreviewParameterProvider<ApiItem> {
    override val values = sequenceOf(PreviewApiItem)
}

class ApiItemMultiPreview : PreviewParameterProvider<List<ApiItem>> {
    override val values = sequenceOf(
        List(50) { PreviewApiItem }
    )
}

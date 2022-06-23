/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [ApiItem.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:49
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.shared.compose.composable.BorderOption
import land.sungbin.apilibrary.shared.compose.composable.RoundBorderText
import land.sungbin.apilibrary.shared.compose.preview.ApiItemSinglePreview
import land.sungbin.apilibrary.shared.compose.preview.BackgroundPreview
import land.sungbin.apilibrary.util.Browser

@OptIn(ExperimentalMaterial3Api::class) // Card
@BackgroundPreview
@Composable
fun ApiItem(
    modifier: Modifier = Modifier,
    @PreviewParameter(ApiItemSinglePreview::class) api: ApiItem
) {
    // must activity context - open browser
    val context = LocalContext.current
    val subTexts = remember(api) {
        buildList {
            if (api.authType.isNotEmpty()) {
                add(api.authType)
            }
            if (api.https) {
                add("HTTPS")
            }
            if (api.cors) {
                add("CORS")
            }
        }
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        onClick = {
            Browser.open(
                context = context,
                url = api.link
            )
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = api.apiName,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = api.category,
                    style = MaterialTheme.typography.titleSmall
                )
            }
            Text(
                text = api.description,
                style = MaterialTheme.typography.bodyLarge,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                subTexts.forEach { text ->
                    RoundBorderText(
                        text = text,
                        shape = RoundedCornerShape(8.dp),
                        innerPadding = PaddingValues(
                            horizontal = 8.dp,
                            vertical = 5.dp
                        ),
                        borderOption = BorderOption(
                            color = MaterialTheme.colorScheme.outline
                        ),
                        style = MaterialTheme.typography.labelLarge.copy(
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    )
                }
            }
        }
    }
}

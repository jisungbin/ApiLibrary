/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [MainScreen.kt] created by Ji Sungbin on 22. 6. 23. 오전 4:26
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.composable

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import land.sungbin.apilibrary.R
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.shared.compose.extension.NavigationBarHeightDp
import land.sungbin.apilibrary.shared.compose.extension.StatusBarHeightDp
import land.sungbin.apilibrary.shared.compose.operator.plus
import land.sungbin.apilibrary.shared.compose.preview.ApiItemMultiPreview
import land.sungbin.apilibrary.shared.compose.preview.BackgroundPreview
import land.sungbin.apilibrary.shared.compose.rememberToast

@OptIn(
    ExperimentalMaterial3Api::class, // Scaffold
    ExperimentalFoundationApi::class // animateItemPlacement
)
@BackgroundPreview
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    @PreviewParameter(ApiItemMultiPreview::class) apiItems: List<ApiItem>
) {
    val toast = rememberToast()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.navigationBarsPadding(),
                onClick = { toast("TODO") }
            ) {
                Icon(
                    painter = painterResource(R.drawable.round_filter_list_24),
                    contentDescription = null
                )
            }
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = padding + PaddingValues(
                top = StatusBarHeightDp,
                bottom = NavigationBarHeightDp + 16.dp
            )
        ) {
            items(
                items = apiItems,
                key = { api -> api.apiName }
            ) { apiItem ->
                ApiItem(
                    modifier = Modifier.animateItemPlacement(),
                    api = apiItem
                )
            }
        }
    }
}

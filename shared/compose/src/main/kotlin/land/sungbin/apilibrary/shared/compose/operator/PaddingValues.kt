/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [PaddingValues.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:39
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.compose.operator

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.platform.LocalLayoutDirection

@Composable
@Stable
operator fun PaddingValues.plus(other: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        start = this.calculateStartPadding(layoutDirection) + other.calculateStartPadding(
            layoutDirection
        ),
        end = this.calculateEndPadding(layoutDirection) + other.calculateEndPadding(layoutDirection),
        top = this.calculateTopPadding() + other.calculateTopPadding(),
        bottom = this.calculateBottomPadding() + other.calculateBottomPadding()
    )
}

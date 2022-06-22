/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [WindowInsets.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:35
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.compose.extension

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity

val NavigationBarHeight
    @Composable
    get() = WindowInsets.systemBars.getBottom(LocalDensity.current)

val StatusBarHeight
    @Composable
    get() = WindowInsets.systemBars.getTop(LocalDensity.current)

val NavigationBarHeightDp
    @Composable
    get() = with(LocalDensity.current) {
        WindowInsets.systemBars.getBottom(this).toDp()
    }

val StatusBarHeightDp
    @Composable
    get() = with(LocalDensity.current) {
        WindowInsets.systemBars.getTop(this).toDp()
    }

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [modifier.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:15
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.compose.extension

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit) = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() },
        onClick = { onClick() },
    )
}

fun Modifier.verticalInsetsPadding() = composed {
    windowInsetsPadding(
        WindowInsets.systemBars.only(
            WindowInsetsSides.Vertical
        )
    )
}

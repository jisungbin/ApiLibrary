/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [BorderComposable.kt] created by Ji Sungbin on 22. 6. 23. 오전 3:49
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.compose.composable

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import land.sungbin.apilibrary.shared.domain.extension.runIf

@Immutable
data class BorderOption(
    val width: Dp = 1.dp,
    val color: Color = Color.White,
)

@Immutable
data class TextOption(
    val overflow: TextOverflow = TextOverflow.Clip,
    val softWrap: Boolean = true,
    val maxLines: Int = Int.MAX_VALUE,
)

@Composable
fun RoundBorderText(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = CircleShape,
    innerPadding: PaddingValues = PaddingValues(10.dp),
    text: String,
    style: TextStyle = LocalTextStyle.current,
    borderOption: BorderOption = BorderOption(),
    textOption: TextOption = TextOption(),
    onClick: (() -> Unit)? = null,
) {
    Text(
        modifier = modifier
            .clip(shape)
            .border(
                width = borderOption.width,
                color = borderOption.color,
                shape = shape
            )
            .runIf(onClick != null) {
                clickable(
                    enabled = enabled,
                    onClick = onClick!!
                )
            }
            .padding(innerPadding),
        text = text,
        style = style,
        overflow = textOption.overflow,
        softWrap = textOption.softWrap,
        maxLines = textOption.maxLines
    )
}

@Composable
fun CircleBorderText(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: Dp = 40.dp,
    text: String,
    style: TextStyle = LocalTextStyle.current,
    borderOption: BorderOption = BorderOption(),
    textOption: TextOption = TextOption(),
    onClick: (() -> Unit)? = null,
) {
    CircleBorderContent(
        modifier = modifier,
        enabled = enabled,
        size = size,
        borderOption = borderOption,
        onClick = onClick
    ) {
        Text(
            text = text,
            style = style.copy(textAlign = TextAlign.Center),
            overflow = textOption.overflow,
            softWrap = textOption.softWrap,
            maxLines = textOption.maxLines
        )
    }
}

@Composable
fun CircleBorderContent(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    size: Dp = 40.dp,
    borderOption: BorderOption = BorderOption(),
    onClick: (() -> Unit)? = null,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .border(
                width = borderOption.width,
                color = borderOption.color,
                shape = CircleShape
            )
            .runIf(onClick != null) {
                clickable(
                    enabled = enabled,
                    onClick = onClick!!
                )
            },
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

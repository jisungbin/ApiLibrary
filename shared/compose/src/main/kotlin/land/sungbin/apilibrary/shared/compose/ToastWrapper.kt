/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [ToastWrapper.kt] created by Ji Sungbin on 22. 6. 22. 오후 10:26
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.compose

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

class ToastWrapper(context: Context) {
    private val instance = Toast(context)

    operator fun invoke(
        message: String,
        length: Int = Toast.LENGTH_SHORT,
    ) {
        show(
            message = message,
            length = length
        )
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun show(
        message: String,
        length: Int = Toast.LENGTH_SHORT,
    ) {
        instance.run {
            setText(message)
            duration = length
            show()
        }
    }
}

@Composable
fun rememberToast(): ToastWrapper {
    val context = LocalContext.current.applicationContext
    return remember(context) {
        ToastWrapper(context)
    }
}

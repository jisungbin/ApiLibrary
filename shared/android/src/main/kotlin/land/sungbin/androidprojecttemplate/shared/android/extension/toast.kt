/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [toast.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.androidprojecttemplate.shared.android.extension

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

fun Activity.toast(
    message: String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = applicationContext,
    message = message,
    length = length
)

fun Fragment.toast(
    message: String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = requireContext(),
    message = message,
    length = length
)

fun toast(
    context: Context,
    messageBuilder: Context.() -> String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = context,
    message = messageBuilder(context),
    length = length
)

fun toast(
    context: Context,
    message: String,
    length: Int = Toast.LENGTH_SHORT,
) = toastBuilder(
    context = context,
    message = message,
    length = length
)

private fun toastBuilder(
    context: Context,
    message: String,
    length: Int,
) {
    Toast.makeText(context, message, length).show()
}

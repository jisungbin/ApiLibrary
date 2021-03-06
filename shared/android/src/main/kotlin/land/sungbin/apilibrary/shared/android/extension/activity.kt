/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [activity.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.android.extension

import android.app.Activity
import android.content.Intent
import android.view.WindowManager
import android.widget.Toast
import androidx.core.view.WindowCompat
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import land.sungbin.apilibrary.shared.domain.extension.toMessage

inline fun <reified T : Activity> Activity.changeActivityWithAnimation(
    intentBuilder: Intent.() -> Intent = { this }
) {
    startActivityWithAnimation<T>(
        intentBuilder = intentBuilder,
        withFinish = true
    )
}

inline fun <reified T : Activity> Activity.startActivityWithAnimation(
    intentBuilder: Intent.() -> Intent = { this },
    withFinish: Boolean = false
) {
    startActivity(intentBuilder(Intent(this, T::class.java)))
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    if (withFinish) finish()
}

fun Activity.finishWithAnimation() {
    finish()
    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
}

fun Activity.setWindowInsetsUsage() {
    window.setFlags( // 네비게이션바까지 영역 확장하려면 필요
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )
    WindowCompat.setDecorFitsSystemWindows(window, false)
}

fun Activity.basicExceptionHandler(exception: Throwable) {
    toast(
        message = exception.toMessage(),
        length = Toast.LENGTH_LONG
    )
    logeukes(type = LoggerType.E) { exception }
}

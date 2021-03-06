/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [Browser.kt] created by Ji Sungbin on 22. 6. 23. 오전 2:24
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.util

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import io.github.jisungbin.logeukes.LoggerType
import io.github.jisungbin.logeukes.logeukes
import land.sungbin.apilibrary.R
import land.sungbin.apilibrary.shared.android.extension.toast

object Browser {
    // TODO: performance increase by using client.warmup()
    /*private const val ChromePackage = "com.android.chrome"
    private var customTabsClientWrapper = WeakReference<CustomTabsClient?>(null)
    private val customTabsClient get() = customTabsClientWrapper.get()!!
    private val customTabsSession by lazy { customTabsClient.newSession(CustomTabsCallback()) }

    private val connection = object : CustomTabsServiceConnection() {
        override fun onServiceDisconnected(name: ComponentName?) {
            customTabsClientWrapper = WeakReference(null)
        }

        override fun onCustomTabsServiceConnected(name: ComponentName, client: CustomTabsClient) {
            client.warmup(0L)
            customTabsClientWrapper = WeakReference(client)
        }
    }

    private val isAvailableChrome by lazy {
        try {
            Class.forName("android.support.customtabs.CustomTabsClient")
            true
        } catch (ignored: Exception) {
            false
        }
    }

    fun startup(context: Context) = // FIXME: always return false
        CustomTabsClient.bindCustomTabsService(context, ChromePackage, connection)*/

    private lateinit var customTabIntent: CustomTabsIntent

    fun open(context: Context, url: String) {
        try {
            if (!::customTabIntent.isInitialized) {
                customTabIntent = CustomTabsIntent.Builder(/*customTabsSession*/)
                    .setShareState(CustomTabsIntent.SHARE_STATE_OFF)
                    /*.setStartAnimations(
                        context,
                        R.anim.slide_in_right,
                        R.anim.slide_out_left
                    )
                    .setExitAnimations(
                        context,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right
                    )*/
                    .build()
                    .also { customTabIntent ->
                        customTabIntent.intent.putExtra(
                            Intent.EXTRA_REFERRER,
                            Uri.parse("android-app://${context.packageName}")
                        )
                    }
            }
            customTabIntent.launchUrl(context, Uri.parse(url))
        } catch (exception: ActivityNotFoundException) {
            logeukes(type = LoggerType.E) { exception }
            toast(
                context = context,
                messageBuilder = { getString(R.string.browser_toast_browser_not_found) }
            )
        }
    }
}

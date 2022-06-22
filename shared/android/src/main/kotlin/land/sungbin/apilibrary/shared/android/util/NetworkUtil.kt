/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [NetworkUtil.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.android.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

object NetworkUtil {
    fun isNetworkAvailable(context: Context) =
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                isNetworkAvailableApi23()
            } else {
                isNetworkAvailableBeforeApi23()
            }
        }

    @RequiresApi(Build.VERSION_CODES.M)
    @Suppress("MissingPermission") // getNetworkCapabilities
    private fun ConnectivityManager.isNetworkAvailableApi23() =
        getNetworkCapabilities(activeNetwork)?.run {
            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)
        } ?: false

    @Suppress(
        "DEPRECATION", // activeNetworkInfo
        "MissingPermission" // activeNetworkInfo
    )
    private fun ConnectivityManager.isNetworkAvailableBeforeApi23(): Boolean {
        val activeNetworkInfo = activeNetworkInfo
        if (activeNetworkInfo != null) {
            val type = activeNetworkInfo.type
            if (type == ConnectivityManager.TYPE_MOBILE || type == ConnectivityManager.TYPE_WIFI) {
                return true
            }
        }
        return false
    }
}

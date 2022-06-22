/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [MainActivity.kt] created by Ji Sungbin on 22. 6. 22. 오후 11:22
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import land.sungbin.apilibrary.composable.MainScreen
import land.sungbin.apilibrary.shared.compose.preview.ApiItemMultiPreview
import land.sungbin.apilibrary.shared.compose.theme.ApiLibraryTheme
import land.sungbin.apilibrary.util.Browser

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Browser.startup(applicationContext)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            val isDarkMode = isSystemInDarkTheme()

            LaunchedEffect(Unit) {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = !isDarkMode
                )
                systemUiController.setNavigationBarColor(
                    color = when (isDarkMode) {
                        true -> Color.Black.copy(alpha = 0.2f)
                        else -> Color.White.copy(alpha = 0.5f)
                    },
                    darkIcons = !isDarkMode
                )
            }

            ApiLibraryTheme {
                MainScreen(
                    modifier = Modifier.fillMaxSize(),
                    apiItems = ApiItemMultiPreview().values.first()
                )
            }
        }
    }
}

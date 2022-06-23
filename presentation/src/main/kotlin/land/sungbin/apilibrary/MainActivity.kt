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
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import land.sungbin.apilibrary.composable.MainScreen
import land.sungbin.apilibrary.domain.model.ApiItem
import land.sungbin.apilibrary.mvi.MainSideEffect
import land.sungbin.apilibrary.mvi.MainState
import land.sungbin.apilibrary.shared.compose.theme.ApiLibraryTheme
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        Browser.startup(applicationContext).also(::println)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val systemUiController = rememberSystemUiController()
            val isDarkMode = isSystemInDarkTheme()
            val vm by viewModels<MainViewModel>()

            var apiItems by remember { mutableStateOf(emptyList<ApiItem>()) }

            LaunchedEffect(Unit) {
                vm.loadPublicApis()
                vm.observe(
                    lifecycleOwner = this@MainActivity,
                    state = { mainState ->
                        handleState(
                            state = mainState,
                            updateApiItemState = { newApiItems ->
                                apiItems = newApiItems
                            }
                        )
                    },
                    sideEffect = ::handleSideEffect
                )

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
                    apiItems = apiItems
                )
            }
        }
    }

    private fun handleState(
        state: MainState,
        updateApiItemState: (apiItem: List<ApiItem>) -> Unit
    ) {
        when (state) {
            MainState.Loading -> {
                // TODO: show loading
            }
            is MainState.LoadDone -> {
                updateApiItemState(state.apiItems)
            }
            is MainState.Fail -> {
                // TODO: show error
            }
        }
    }

    private fun handleSideEffect(sideEffect: MainSideEffect) {
        when (sideEffect) {
            is MainSideEffect.SaveToDatabase -> {
                // TODO: save to room database
            }
        }
    }
}

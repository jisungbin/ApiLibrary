/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [MainState.kt] created by Ji Sungbin on 22. 6. 23. 오후 2:49
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.mvi

import land.sungbin.apilibrary.domain.model.ApiItem

sealed class MainState {
    object Loading : MainState()
    data class LoadDone(val apiItems: List<ApiItem>) : MainState()
    data class Fail(val throwable: Throwable) : MainState()
}

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [MainSideEffect.kt] created by Ji Sungbin on 22. 6. 23. 오후 2:48
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.mvi

import land.sungbin.apilibrary.domain.model.ApiItem

sealed class MainSideEffect {
    data class SaveToDatabase(val apis: List<ApiItem>) : MainSideEffect()
}

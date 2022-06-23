/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [MainViewModel.kt] created by Ji Sungbin on 22. 6. 23. 오후 2:45
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary

import dagger.hilt.android.lifecycle.HiltViewModel
import land.sungbin.apilibrary.domain.usecase.PublicApiEntriesFetchUseCase
import land.sungbin.apilibrary.mvi.MainSideEffect
import land.sungbin.apilibrary.mvi.MainState
import land.sungbin.apilibrary.shared.android.base.BaseViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val publicApiEntriesFetchUseCase: PublicApiEntriesFetchUseCase
) : BaseViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container = container<MainState, MainSideEffect>(MainState.Loading)

    fun loadPublicApis() = intent {
        publicApiEntriesFetchUseCase()
            .onSuccess { publicApi ->
                val entries = publicApi.entries
                reduce {
                    MainState.LoadDone(entries)
                }
                postSideEffect(MainSideEffect.SaveToDatabase(entries))
            }
            .onFailure { exception ->
                reduce {
                    MainState.Fail(exception)
                }
            }
    }
}

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [BaseViewModel.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:13
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.android.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    private val _exceptionChannel = Channel<Throwable>()
    val exceptionFlow = _exceptionChannel.receiveAsFlow()

    open fun emitException(exception: Throwable) {
        viewModelScope.launch {
            _exceptionChannel.send(exception)
        }
    }
}

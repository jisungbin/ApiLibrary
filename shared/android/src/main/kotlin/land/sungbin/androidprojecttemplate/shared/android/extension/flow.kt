/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [flow.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.androidprojecttemplate.shared.android.extension

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

fun <T> Flow<T>.collectWithLifecycle(
    lifecycleOwner: LifecycleOwner,
    minActiveState: Lifecycle.State = Lifecycle.State.CREATED,
    builder: Flow<T>.() -> Flow<T> = { this },
    action: suspend CoroutineScope.(T) -> Unit,
) {
    lifecycleOwner.lifecycleScope.launchWhenCreated {
        builder()
            .flowWithLifecycle(
                lifecycle = lifecycleOwner.lifecycle,
                minActiveState = minActiveState
            ).collect { value ->
                action(value)
            }
    }
}

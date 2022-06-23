/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [PublicApiEntriesFetchUseCase.kt] created by Ji Sungbin on 22. 6. 23. 오후 2:42
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.domain.usecase

import land.sungbin.apilibrary.domain.repository.PublicApiRepository

class PublicApiEntriesFetchUseCase(private val repository: PublicApiRepository) {
    suspend operator fun invoke() = runCatching {
        repository.getEntries()
    }
}

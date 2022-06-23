/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [PublicApiRepository.kt] created by Ji Sungbin on 22. 6. 23. 오후 12:27
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.domain.repository

import land.sungbin.apilibrary.domain.model.PublicApi

interface PublicApiRepository {
    suspend fun getEntries(): PublicApi
}

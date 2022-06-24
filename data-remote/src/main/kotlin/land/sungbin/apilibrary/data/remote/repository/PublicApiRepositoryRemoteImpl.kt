/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [PublicApiRepositoryImpl.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

CChpackage land.sungbin.apilibrary.data.remote.repository

import land.sungbin.apilibrary.data.remote.extension.publicApiApi
import land.sungbin.apilibrary.data.remote.extension.requireSuccessfulBody
import land.sungbin.apilibrary.data.remote.mapper.toDomain
import land.sungbin.apilibrary.domain.model.PublicApi
import land.sungbin.apilibrary.domain.repository.PublicApiRepository

class PublicApiRepositoryRemoteImpl : PublicApiRepository {
    override suspend fun getEntries(): PublicApi {
        val response = publicApiApi
            .fetchEntries()
            .requireSuccessfulBody("PublicApiRepository.fetchEntries")
        return response.toDomain()
    }
}

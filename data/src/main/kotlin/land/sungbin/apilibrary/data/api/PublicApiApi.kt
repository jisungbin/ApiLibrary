/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [PublicApiApi.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:26
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.api

import land.sungbin.apilibrary.data.model.PublicApiResponse
import retrofit2.Response
import retrofit2.http.GET

internal interface PublicApiApi {
    @GET("/entries")
    suspend fun fetchEntries(): Response<PublicApiResponse>
}

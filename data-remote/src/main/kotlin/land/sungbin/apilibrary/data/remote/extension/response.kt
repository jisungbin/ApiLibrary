/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [response.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:33
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.remote.extension

import retrofit2.Response

internal inline fun <T> Response<T>.requireSuccessfulBody(
    requestName: String,
    resultVerifyBuilder: (body: T) -> Boolean = { true },
): T {
    val body = body()
    return if (isSuccessful && body != null && resultVerifyBuilder(body)) {
        body
    } else {
        throw IllegalStateException(
            """
            Request $requestName is fail.
            Http message: ${errorBody()?.use { it.string() }}
            """.trimIndent()
        )
    }
}

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [retrofit.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:27
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.remote.extension

import io.github.jisungbin.logeukes.logeukes
import java.util.concurrent.TimeUnit
import land.sungbin.apilibrary.data.remote.api.PublicApiApi
import land.sungbin.apilibrary.shared.domain.dsl.ApiLibraryDsl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

internal data class ClientModel(
    var interceptors: List<Interceptor> = emptyList(),
    var builder: OkHttpClient.Builder.() -> OkHttpClient.Builder = { this },
)

private fun getHttpLoggingInterceptor() = HttpLoggingInterceptor { message ->
    if (message.isNotEmpty()) {
        logeukes(tag = "OkHttp") { message }
    }
}.apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private fun OkHttpClient.Builder.setTimeout(second: Long = 5) =
    connectTimeout(second, TimeUnit.SECONDS)
        .readTimeout(second, TimeUnit.SECONDS)
        .writeTimeout(second, TimeUnit.SECONDS)

private fun buildClient(@ApiLibraryDsl builder: ClientModel.() -> Unit): OkHttpClient {
    val clientModel = ClientModel().apply(builder)
    val client = OkHttpClient.Builder().apply {
        clientModel.builder
    }
    for (interceptor in clientModel.interceptors) {
        client.addInterceptor(interceptor)
    }
    return client.build()
}

private val publicApiBaseApi = Retrofit.Builder()
    .baseUrl("https://api.publicapis.org/")
    .addConverterFactory(JacksonConverter)
    .client(
        buildClient {
            builder = {
                setTimeout()
            }
            interceptors = listOf(getHttpLoggingInterceptor())
        }
    )
    .build()

internal val publicApiApi = publicApiBaseApi.create(PublicApiApi::class.java)

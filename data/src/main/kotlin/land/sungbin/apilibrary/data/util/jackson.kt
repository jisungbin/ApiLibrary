/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [jackson.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:30
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.util

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import retrofit2.converter.jackson.JacksonConverterFactory

@PublishedApi
internal val JacksonObjectMapper = ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .registerKotlinModule()

internal val JacksonConverter = JacksonConverterFactory.create(JacksonObjectMapper)

inline fun <reified T> String.toModel(): T = JacksonObjectMapper.readValue(this, T::class.java)

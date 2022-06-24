/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [json.kt] created by Ji Sungbin on 22. 6. 24. 오전 9:12
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule

val JacksonObjectMapper = ObjectMapper()
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
    .registerKotlinModule()

inline fun <reified T> String.toModel(): T = JacksonObjectMapper.readValue(this, T::class.java)

fun Any.toJsonString() = JacksonObjectMapper.writeValueAsString(this)

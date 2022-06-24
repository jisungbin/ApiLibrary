/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [jackson.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:30
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data.remote.extension

import JacksonObjectMapper
import retrofit2.converter.jackson.JacksonConverterFactory

internal val JacksonConverter = JacksonConverterFactory.create(JacksonObjectMapper)

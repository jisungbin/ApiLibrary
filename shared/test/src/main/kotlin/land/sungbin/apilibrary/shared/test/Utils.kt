/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [Utils.kt] created by Ji Sungbin on 22. 6. 23. 오전 9:37
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.test

object Utils {
    fun readResourceString(fileName: String) =
        this::class.java.classLoader?.getResource(fileName)?.readText().orEmpty()
}

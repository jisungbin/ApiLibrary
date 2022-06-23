/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [DummyText.kt] created by Ji Sungbin on 22. 6. 23. 오전 9:33
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.test

object PublicApiResponseDummy {
    val Entries = Utils.readResourceString("entries-response.json")
    val Categories = Utils.readResourceString("categories-response.json")
}

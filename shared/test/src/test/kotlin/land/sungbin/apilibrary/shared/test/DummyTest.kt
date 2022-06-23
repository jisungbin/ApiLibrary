/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [DummyTest.kt] created by Ji Sungbin on 22. 6. 23. 오전 9:53
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.shared.test

import org.junit.Test

class DummyTest {
    @Test
    fun `entries response dummy json count must be 1421`() {
        assert(PublicApiResponseDummy.Entries.contains("\"count\": 1421"))
    }

    @Test
    fun `categories response dummy json count must be 51`() {
        assert(PublicApiResponseDummy.Categories.contains("\"count\": 51"))
    }
}

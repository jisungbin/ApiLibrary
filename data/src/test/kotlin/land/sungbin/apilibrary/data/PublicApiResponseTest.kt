/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [PublicApiResponseTest.kt] created by Ji Sungbin on 22. 6. 23. 오후 1:44
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.data

import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import land.sungbin.apilibrary.data.mapper.toDomain
import land.sungbin.apilibrary.data.model.PublicApiResponse
import land.sungbin.apilibrary.data.util.toModel
import land.sungbin.apilibrary.domain.repository.PublicApiRepository
import land.sungbin.apilibrary.shared.test.PublicApiResponseDummy
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class) // runTest
class PublicApiResponseTest {
    @get:Rule
    val mockkRule = MockKRule(this)

    @MockK
    lateinit var publicApiRepository: PublicApiRepository

    @Before
    fun setUp() {
        coEvery { publicApiRepository.getEntries() } returns PublicApiResponseDummy
            .Entries
            .toModel<PublicApiResponse>()
            .toDomain()
    }

    @Test
    fun `fetched public api entries count must be 1421`() = runTest {
        val count = publicApiRepository.getEntries().count
        assert(count == 1421)
    }

    @Test
    fun `fetched public api categories count must be 51`() = runTest {
        val count = publicApiRepository
            .getEntries()
            .entries
            .groupBy { it.category }
            .size
        assert(count == 51)
    }
}

/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [RepositoryModule.kt] created by Ji Sungbin on 22. 6. 23. 오후 2:40
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.apilibrary.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import land.sungbin.apilibrary.data.remote.repository.PublicApiRepositoryRemoteImpl
import land.sungbin.apilibrary.domain.repository.PublicApiRepository

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {
    @Provides
    fun provideRepository(): PublicApiRepository = PublicApiRepositoryRemoteImpl()
}

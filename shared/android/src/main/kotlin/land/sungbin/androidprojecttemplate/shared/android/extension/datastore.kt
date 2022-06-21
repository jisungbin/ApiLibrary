/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [datastore.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:14
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.androidprojecttemplate.shared.android.extension

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

// TODO: set your DataStore name
private const val DataStoreName = "TODO"

val Context.dataStore by preferencesDataStore(
    name = DataStoreName
)

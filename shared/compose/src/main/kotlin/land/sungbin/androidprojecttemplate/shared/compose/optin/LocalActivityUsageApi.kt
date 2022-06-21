/*
 * ApiLibrary © 2022 Ji Sungbin. all rights reserved.
 * ApiLibrary license is under the MIT.
 *
 * [LocalActivityUsageApi.kt] created by Ji Sungbin on 22. 6. 22. 오전 3:21
 *
 * Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
 */

package land.sungbin.androidprojecttemplate.shared.compose.optin

@RequiresOptIn(message = "This API uses LocalActivity. Check if the Activity is being present.")
@Retention(AnnotationRetention.BINARY)
annotation class LocalActivityUsageApi

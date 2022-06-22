@file:Suppress("OPT_IN_IS_NOT_ENABLED")
/*
* ApiLibrary © 2022 Ji Sungbin. all rights reserved.
* ApiLibrary license is under the MIT.
*
* [optin.kt] created by Ji Sungbin on 22. 6. 22. 오후 11:01
*
* Please see: https://github.com/jisungbin/ApiLibrary/blob/main/LICENSE.
*/

@RequiresOptIn(message = "This dependency must be DebugImplementation.")
@Retention(AnnotationRetention.BINARY)
annotation class DebugImplementation

@RequiresOptIn(message = "This dependency must be AndroidTestImplementation.")
@Retention(AnnotationRetention.BINARY)
annotation class AndroidTestImplementation

// https://github.com/JakeWharton/timber/blob/trunk/timber/src/main/java/timber/log/Timber.kt#L204

package land.sungbin.apilibrary.shared.domain.extension

import android.os.Build
import java.util.regex.Pattern

private const val MaxTagLength = 23
private val AnonymousClass = Pattern.compile("(\\$\\d+)+$")

val Throwable.tag
    get() = stackTrace
        .first()
        .let(::createStackElementTag)

private fun createStackElementTag(element: StackTraceElement): String {
    var tag = element.className.substringAfterLast('.')
    val m = AnonymousClass.matcher(tag)
    if (m.find()) {
        tag = m.replaceAll("")
    }
    return if (tag.length <= MaxTagLength || Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        tag
    } else {
        tag.substring(0, MaxTagLength)
    }
}

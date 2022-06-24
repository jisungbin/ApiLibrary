// enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS") 버그이씀 (모듈 많아지면 새로운 모듈 인식 안됨)
@Suppress("SpellCheckingInspection")
object ProjectConstants {
    const val Domain = ":domain"
    const val DataLocal = ":data-local"
    const val DataRemote = ":data-remote"
    const val Presentation = ":presentation"
    const val SharedTest = ":shared:test"
    const val SharedDomain = ":shared:domain"
    const val SharedCompose = ":shared:compose"
    const val SharedAndroid = ":shared:android"
}

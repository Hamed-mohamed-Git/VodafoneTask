plugins{
    alias(libs.plugins.vodafone.android.library)
    alias(libs.plugins.vodafone.android.hilt)
    alias(libs.plugins.vodafone.android.default.config)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    //Name Spacing
    namespace = "com.vodafone.task.core.network"
}

dependencies {

    //Local Module
    api(projects.core.model)
    api(projects.core.common)

    //chucker
    debugImplementation(libs.chucker)
    releaseImplementation(libs.chucker.no.op)

    //ktor
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.okhttp)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.serialization.kotlinx.json)

}

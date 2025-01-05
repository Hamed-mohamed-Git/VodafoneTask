import java.io.FileInputStream
import java.util.Properties

plugins{
    alias(libs.plugins.vodafone.android.library)
    alias(libs.plugins.vodafone.android.hilt)
    alias(libs.plugins.kotlinx.serialization)
}

android {

    //Name Spacing
    namespace = "com.vodafone.task.core.network"

    //For Load Properties
    defaultConfig {

//        loadProperties().run {
//            //TODO: Any KEY Should save it using Native C++ Bridge "NDK & JNI"
//            // for High security level to avoid getting them easily
//            // by reverse engineering
//            buildConfigField("String","BASE_URL",properties["WEATHER_BASE_URL"] as String)
//            buildConfigField("String","API_KEY",properties["WEATHER_API_KEY"] as String)
//        }

    }
}

dependencies {

    //Local Module
    implementation(projects.core.model)
    implementation(projects.core.common)

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

internal fun loadProperties(fileName:String = "credentials.properties") = Properties()
    .apply { load(FileInputStream(rootProject.file(fileName))) }
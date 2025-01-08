plugins {
    alias(libs.plugins.vodafone.android.library.compose)
    alias(libs.plugins.vodafone.android.library)
}

android {
    namespace = "com.vodafone.task.core.designSystem"
}

dependencies {

    //Compose Dependencies
    implementation(libs.androidx.compose.ui.text.google.fonts)
}
plugins {
    alias(libs.plugins.vodafone.android.library.compose)
    alias(libs.plugins.vodafone.android.library)
}

android {
    namespace = "com.vodafone.task.core.ui"
}

dependencies {
    //Local Modules
    implementation(projects.core.designSystem)
}
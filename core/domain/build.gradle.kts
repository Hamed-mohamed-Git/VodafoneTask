plugins {
    alias(libs.plugins.vodafone.android.hilt)
    alias(libs.plugins.vodafone.android.library)
}

android {
    namespace = "com.vodafone.task.core.domain"
}

dependencies {
    //Local Modules
    implementation(projects.core.model)
    implementation(projects.core.data)
}
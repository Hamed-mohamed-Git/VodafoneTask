plugins {
    alias(libs.plugins.vodafone.android.library)
}

android {
    //Name Spacing
    namespace = "com.vodafone.task.core.model"
}

dependencies {
    //Local module
    implementation(projects.core.common)
}

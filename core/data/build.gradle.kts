plugins {
    alias(libs.plugins.vodafone.android.library)
    alias(libs.plugins.vodafone.android.hilt)
}

android{
    namespace = "com.vodafone.task.core.data"
}

dependencies{
    //Local Modules
    implementation(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.core.utils)
}
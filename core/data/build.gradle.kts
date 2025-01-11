plugins {
    alias(libs.plugins.vodafone.android.library)
    alias(libs.plugins.vodafone.android.hilt)
}

android{
    namespace = "com.vodafone.task.core.data"
}

dependencies{
    //Local Modules
    api(projects.core.model)
    api(projects.core.common)
    api(projects.core.utils)
    implementation(projects.core.network)
    implementation(projects.core.database)
}
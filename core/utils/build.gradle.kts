plugins {
    alias(libs.plugins.vodafone.android.library)
    alias(libs.plugins.vodafone.android.hilt)
    alias(libs.plugins.vodafone.android.maven.publish)
}

android{
    namespace = "com.vodafone.task.core.utils"
}
plugins {
    alias(libs.plugins.vodafone.android.library)
    alias(libs.plugins.vodafone.android.hilt)
    alias(libs.plugins.vodafone.android.room)
}

android{
    namespace = "com.vodafone.task.core.database"
}

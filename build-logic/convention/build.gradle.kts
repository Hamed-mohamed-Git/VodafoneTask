plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle)
    compileOnly(libs.kotlin.gradle)
    compileOnly(libs.compose.gradle)
    compileOnly(libs.ksp.gradle)
    compileOnly(libs.room.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "vodafone.task.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }

        register("androidLibrary") {
            id = "vodafone.task.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidLibraryCompose") {
            id = "vodafone.task.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }

        register("androidApplication") {
            id = "vodafone.task.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("room") {
            id = "vodafone.task.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }

        register("androidHilt") {
            id = "vodafone.task.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidFeature") {
            id = "vodafone.task.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }

        register("androidMavenPublish") {
            id = "vodafone.task.android.maven-publish"
            implementationClass = "PublishKotlinLibraryConventionPlugin"
        }

        register("androidDefaultConfig") {
            id = "vodafone.task.android.default-config"
            implementationClass = "AndroidDefaultConfigConventionPlugin"
        }

    }
}
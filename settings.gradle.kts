rootProject.name = "vodafoneTask"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
includeBuild("build-logic")

pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

//Local module include
include(":app")
include(":core:network")
include(":core:common")
include(":core:model")
include(":core:data")
include(":core:database")
include(":core:utils")
include(":core:domain")
include(":core:design-system")
include(":core:ui")

package com.build_logic.convention

import com.android.build.api.dsl.CommonExtension
import com.build_logic.convention.utils.sourceSets
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.api.resources.TextResource
import org.gradle.api.tasks.Sync
import org.gradle.kotlin.dsl.register
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.util.Properties


private fun Project.configureKotlin() {
    configureKotlinJvm()

    tasks.withType<KotlinCompile> {
        compilerOptions.freeCompilerArgs.addAll(
            "-opt-in=kotlin.RequiresOptIn",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            "-opt-in=kotlinx.coroutines.FlowPreview",
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
            "-opt-in=androidx.compose.foundation.ExperimentalFoundationApi",
            "-opt-in=androidx.compose.animation.ExperimentalSharedTransitionApi",
            "-opt-in=androidx.compose.foundation.layout.ExperimentalLayoutApi",
            "-Xcontext-receivers",
            "-Xexpect-actual-classes"
        )
    }
}

internal fun Project.configureKotlinMultiplatform(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    kotlinMultiplatformExtension.apply {
        configureKotlin()
    }

    configureKotlinAndroid(commonExtension)
}

internal fun Project.configureKotlinMultiplatformLibrary(
    kotlinMultiplatformExtension: KotlinMultiplatformExtension,
    commonExtension: CommonExtension<*, *, *, *, *, *>
) {
    kotlinMultiplatformExtension.apply {
        configureKotlinJvm()
        androidTarget()
        iosX64()
        iosArm64()
        iosSimulatorArm64()
        configureKotlin()
        sourceSets {
            commonMain {
                kotlin.srcDir(commonBuildConfigGenerator.map { it.destinationDir })
            }
        }
    }
    configureKotlinAndroid(commonExtension)
}


val Project.commonBuildConfigGenerator
    get() = tasks.register<Sync>("commonBuildConfigGenerator") {
        val properties =
            Properties().apply { load(project.rootProject.file("local.properties").inputStream()) }

        // create a provider for the project version
        val projectVersionProvider: Provider<String> = provider { project.version.toString() }

        val idDebug = project.gradle.startParameter.taskNames.any { it.contains("Debug") }

        // map the project version into a file
        val buildConfigFileContents: Provider<TextResource> =
            projectVersionProvider.map { version ->
                resources.text.fromString(
                    """
          |package ${project.name}
          |
          |internal object CommonBuildConfig {
          |     const val VERSION = "$version"
          |     const val DEBUG = $idDebug
          |     const val PATENTE_URL = "${properties["PATENTE_URL"]}"
          |     const val STRIPE_TEST_SECRET_KEY = "${properties["STRIPE_TEST_SECRET_KEY"]}"
          |     const val STRIPE_PUBLISH_SECRET_KEY = "${properties["STRIPE_PUBLISH_SECRET_KEY"]}"
          |}
          |
        """.trimMargin()
                )
            }

        // Gradle accepts file providers as Sync inputs
        from(buildConfigFileContents) {
            rename { "CommonBuildConfig.kt" }
            into(project.name)
        }

        into(layout.buildDirectory.dir("generated-src/kotlin/"))
    }

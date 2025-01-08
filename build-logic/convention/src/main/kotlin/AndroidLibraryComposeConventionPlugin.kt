
import com.android.build.gradle.LibraryExtension
import com.build_logic.convention.configureAndroidCompose
import com.build_logic.convention.utils.debugImplementation
import com.build_logic.convention.utils.implementation
import com.build_logic.convention.utils.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("com.android.library")
            apply("org.jetbrains.kotlin.plugin.compose")
            apply("org.jetbrains.kotlin.android")
        }
        val extension = extensions.getByType<LibraryExtension>()

        configureAndroidCompose(extension)

        dependencies{
            implementation(platform(library("androidx.compose.bom")))
            implementation(library("androidx-material3"))
            implementation(library("androidx-ui-tooling-preview"))
            implementation(library("androidx-ui"))
            implementation(library("androidx-activity-compose"))
            implementation(library("androidx-ui-graphics"))
            implementation(library("androidx-lifecycle-runtime-ktx"))
            implementation(library("androidx-core-ktx"))
            debugImplementation(library("androidx-ui-tooling"))
            debugImplementation(library("androidx-ui-test-manifest"))
        }
    }
}
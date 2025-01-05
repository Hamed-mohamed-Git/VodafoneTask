import com.android.build.api.dsl.ApplicationExtension
import com.build_logic.convention.configureAndroidCompose
import com.build_logic.convention.utils.implementation
import com.build_logic.convention.utils.library
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(target.pluginManager) {
            apply("com.android.application")
            apply("org.jetbrains.kotlin.android")
            apply("org.jetbrains.kotlin.plugin.compose")
        }

        val extension = extensions.getByType<ApplicationExtension>()
        configureAndroidCompose(extension)

        dependencies {
            implementation(platform(library("androidx.compose.bom")))
        }
    }
}
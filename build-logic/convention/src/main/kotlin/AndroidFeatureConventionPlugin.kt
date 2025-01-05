
import com.build_logic.convention.utils.implementation
import com.build_logic.convention.utils.library
import com.build_logic.convention.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("patente.android.library.compose")
                apply("patente.android.koin")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                implementation(project(":android:core:ui"))
                implementation(project(":shared:handlers"))

                implementation(library("koin.androidx.compose.navigation"))
                implementation(library("koin-androidx-viewmodel"))
                implementation(library("androidx-navigation-compose"))
            }
        }
    }
}
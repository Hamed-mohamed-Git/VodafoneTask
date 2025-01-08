import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import com.build_logic.convention.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.io.FileInputStream
import java.util.Properties

private const val PROPERTIES = "credentials.properties"
private const val API_URL = "WEATHER_BASE_URL"
private const val API_KEY = "WEATHER_API_KEY"
private const val TYPE = "String"

internal class AndroidDefaultConfigConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) = with(target){
        with(pluginManager){
            apply("com.android.library")
            apply("org.jetbrains.kotlin.android")
        }

        extensions.configure<LibraryExtension> {
            defaultConfig {
                //For Loading Properties File
                val pro = loadProperties(target)

                //TODO: Any KEY Should save it using Native C++ Bridge "NDK & JNI"
                // for High security level to avoid getting them easily
                // by reverse engineering
                buildConfigField(TYPE, API_URL, pro.load(API_URL))
                buildConfigField(TYPE, API_KEY, pro.load(API_KEY))
            }
        }
    }
}

private fun Properties.load(name: String) = this[name] as String

private fun loadProperties(project: Project) = Properties()
    .apply { load(project.createInputStream()) }

private fun Project.createInputStream(fileName:String = PROPERTIES) =
    FileInputStream(project.rootProject.file(fileName))

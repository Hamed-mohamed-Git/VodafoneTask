import com.build_logic.convention.utils.library
import com.build_logic.convention.utils.libs
import com.build_logic.convention.utils.version
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.register

class PublishKotlinLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply("maven-publish")
        }

        extensions.configure<PublishingExtension> {
            publications {
                create<MavenPublication>("debug") {
                    groupId = "com.vodafone.task.core.utils"
                    artifactId = "utils-debug"
                    version = version("utilsSdkVersion")
                }

                create<MavenPublication>("release") {
                    groupId = "com.vodafone.task.core.utils"
                    artifactId = "utils"
                    version = version("utilsSdkVersion")
                }
            }
        }

        extensions.configure<PublishingExtension> {
            repositories {
                maven {
                    //Todo: For remote repos configuration
                }
            }
        }
    }
}
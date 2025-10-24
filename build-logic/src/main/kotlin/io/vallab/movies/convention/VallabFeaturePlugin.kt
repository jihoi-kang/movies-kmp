package io.vallab.movies.convention

import io.vallab.movies.library
import io.vallab.movies.libs
import io.vallab.movies.primitive.DetektPlugin
import io.vallab.movies.primitive.KotlinMultiPlatformAndroidPlugin
import io.vallab.movies.primitive.KotlinMultiPlatformPlugin
import io.vallab.movies.primitive.KotlinMultiPlatformiOSPlugin
import io.vallab.movies.primitive.composeMultiplatformDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension

class VallabFeaturePlugin : Plugin<Project> {

    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(
                libs.findPlugin("androidLibrary")
                    .get()
                    .get().pluginId
            )
            apply(
                libs.findPlugin("kotlinMultiplatform")
                    .get()
                    .get().pluginId
            )
            apply(
                libs.findPlugin("composeMultiplatform")
                    .get()
                    .get().pluginId
            )
            apply(
                libs.findPlugin("composeCompiler")
                    .get()
                    .get().pluginId
            )
        }

        apply<KotlinMultiPlatformPlugin>()
        apply<KotlinMultiPlatformAndroidPlugin>()
        apply<KotlinMultiPlatformiOSPlugin>()
        apply<DetektPlugin>()

        composeMultiplatformDependencies()

        extensions.configure<KotlinMultiplatformExtension> {
            sourceSets.apply {
                commonMain {
                    dependencies {
                        implementation(project(":core:designsystem"))
                        implementation(project(":core:navigation"))
                        implementation(libs.library("androidx-navigation-compose"))
                        implementation(libs.library("androidx-lifecycle-runtime-compose"))
                        implementation(libs.library("koin-compose-viewmodel-navigation"))
                    }
                }

            }
        }
    }
}

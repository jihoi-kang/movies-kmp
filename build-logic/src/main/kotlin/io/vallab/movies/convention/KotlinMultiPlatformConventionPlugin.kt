package io.vallab.movies.convention

import io.vallab.movies.libs
import io.vallab.movies.primitive.DetektPlugin
import io.vallab.movies.primitive.KotlinMultiPlatformAndroidPlugin
import io.vallab.movies.primitive.KotlinMultiPlatformPlugin
import io.vallab.movies.primitive.KotlinMultiPlatformiOSPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply

class KotlinMultiPlatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
            apply(libs.findPlugin("kotlinMultiplatform").get().get().pluginId)
        }

        apply<KotlinMultiPlatformPlugin>()
        apply<KotlinMultiPlatformAndroidPlugin>()
        apply<KotlinMultiPlatformiOSPlugin>()
        apply<DetektPlugin>()
    }
}
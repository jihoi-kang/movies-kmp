package io.vallab.movies.convention

import io.vallab.movies.libs
import io.vallab.movies.primitive.composeMultiplatformDependencies
import org.gradle.api.Plugin
import org.gradle.api.Project

class ComposeMultiPlatformConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) = with(target) {
        with(pluginManager) {
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

        composeMultiplatformDependencies()
    }
}

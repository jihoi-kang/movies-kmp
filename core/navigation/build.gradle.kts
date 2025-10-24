plugins {
    alias(libs.plugins.androidLibrary)
    id("vallab.kotlin.multiplatform")
    alias(libs.plugins.kotlinxSerialization)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.serialization.json)
        }
    }
}

android.namespace = "io.vallab.movies.core.navigation"

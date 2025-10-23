plugins {
    alias(libs.plugins.androidLibrary)
    id("vallab.kotlin.multiplatform")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            api(libs.kotlinx.coroutines.core)
            implementation(libs.koin.core)
            implementation(projects.core.datastore)
        }
    }
}

android.namespace = "io.vallab.movies.core.data"

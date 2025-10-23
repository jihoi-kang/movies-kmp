plugins {
    alias(libs.plugins.androidLibrary)
    id("vallab.kotlin.multiplatform")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.koin.core)

            implementation(libs.androidx.datastore.core)
            implementation(libs.androidx.datastore.core.okio)
            implementation(libs.okio)
        }
    }
}

android.namespace = "io.vallab.movies.core.datastore"

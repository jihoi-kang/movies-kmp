plugins {
    alias(libs.plugins.androidLibrary)
    id("vallab.kotlin.multiplatform")
    id("vallab.compose.multiplatform")
}

kotlin {
    sourceSets {
        commonMain {
            dependencies {
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)

                implementation(libs.coil)
                implementation(libs.coil.network)
            }
        }
        appleMain {
            dependencies {
                // NOTHING
            }
        }
        androidMain {
            dependencies {
                // NOTHING
            }
        }
    }
}

compose.resources {
    publicResClass = true
    // ref. https://www.jetbrains.com/help/kotlin-multiplatform-dev/whats-new-compose-180.html#option-to-change-the-generated-res-class-name
    nameOfResClass = "DesignRes"
}

android.namespace = "io.vallab.movies.core.designsystem"

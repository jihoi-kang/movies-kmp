import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    alias(libs.plugins.androidApplication)
    id("vallab.kotlin.multiplatform")
    id("vallab.compose.multiplatform")
}

kotlin {
    targets
        .filterIsInstance<KotlinNativeTarget>()
        .forEach { target ->
            target.binaries {
                framework {
                    baseName = "ComposeApp"
                    isStatic = true
                }
            }
        }

    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)
        }
        commonMain.dependencies {
            implementation(projects.core.designsystem)
            implementation(projects.core.datastore)
            implementation(projects.core.data)
            implementation(projects.core.network)
            implementation(projects.feature.main)
            implementation(projects.feature.home)
            implementation(projects.feature.setting)
            implementation(projects.feature.movieDetail)

            implementation(libs.androidx.lifecycle.runtime.compose)
            implementation(libs.koin.compose.viewmodel.navigation)
        }
    }
}

android {
    namespace = "io.vallab.movies"
    compileSdk = libs.versions.android.compileSdk.get()
        .toInt()

    defaultConfig {
        applicationId = "io.vallab.movies"
        minSdk = libs.versions.android.minSdk.get()
            .toInt()
        targetSdk = libs.versions.android.targetSdk.get()
            .toInt()
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
        }
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

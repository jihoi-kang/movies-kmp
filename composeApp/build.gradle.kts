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

            // todo: need to remove(필요한 것만 빼고 삭제)
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)
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

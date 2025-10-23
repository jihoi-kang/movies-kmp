import com.codingfeline.buildkonfig.compiler.FieldSpec.Type
import org.jetbrains.compose.internal.utils.getLocalProperty

plugins {
    alias(libs.plugins.androidLibrary)
    id("vallab.kotlin.multiplatform")
    alias(libs.plugins.kotlinxSerialization)
    alias(libs.plugins.buildkonfig)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.auth)
            implementation(libs.ktor.serialization.kotlinx.json)
            implementation(libs.ktor.logging)

            implementation(libs.koin.core)
        }

        androidMain.dependencies {
            implementation(libs.ktor.client.okhttp)
        }

        iosMain.dependencies {
            implementation(libs.ktor.client.darwin)
        }
    }
}

val pkg = "io.vallab.movies.core.network"

android.namespace = pkg

buildkonfig {
    packageName = pkg
    defaultConfigs {
        val token = project.getLocalProperty("tmdb.accesstoken")
        buildConfigField(Type.STRING, "TMDB_ACCESS_TOKEN", "$token")
    }
}

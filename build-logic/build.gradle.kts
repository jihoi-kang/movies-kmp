plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(libs.android.gradlePlugin)
    implementation(libs.kotlin.gradlePlugin)
    compileOnly(libs.compose.compiler.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("kmpConvention") {
            id = "vallab.kotlin.multiplatform"
            implementationClass = "io.vallab.movies.convention.KotlinMultiPlatformConventionPlugin"
        }
        register("cmpConvention") {
            id = "vallab.compose.multiplatform"
            implementationClass = "io.vallab.movies.convention.ComposeMultiPlatformConventionPlugin"
        }
    }
}
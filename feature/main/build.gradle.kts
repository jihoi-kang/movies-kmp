plugins {
    id("vallab.feature")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.feature.home)
            implementation(projects.feature.setting)
            implementation(projects.feature.movieDetail)
        }
    }

}

android.namespace = "io.vallab.movies.feature.main"

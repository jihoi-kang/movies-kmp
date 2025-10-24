package io.vallab.movies.feature.setting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.vallab.movies.core.navigation.Route

fun NavGraphBuilder.settingNavGraph() {
    composable<Route.Setting> {
        SettingScreen()
    }
}

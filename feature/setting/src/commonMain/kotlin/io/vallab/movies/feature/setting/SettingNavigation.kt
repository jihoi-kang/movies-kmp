package io.vallab.movies.feature.setting

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import io.vallab.movies.core.navigation.MainTabRoute

fun NavGraphBuilder.settingNavGraph() {
    composable<MainTabRoute.Setting> {
        SettingScreen()
    }
}

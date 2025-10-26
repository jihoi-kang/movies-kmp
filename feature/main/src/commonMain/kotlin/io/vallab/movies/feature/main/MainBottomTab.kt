package io.vallab.movies.feature.main

import io.vallab.movies.core.navigation.MainTabRoute
import io.vallab.movies.core.navigation.Route
import movies.feature.main.generated.resources.Res
import movies.feature.main.generated.resources.ic_home
import movies.feature.main.generated.resources.ic_setting

enum class MainBottomTab {
    HOME,
    SETTING,
}

fun MainBottomTab.route(): Route = when (this) {
    MainBottomTab.HOME -> MainTabRoute.Home
    MainBottomTab.SETTING -> MainTabRoute.Setting
}

fun MainBottomTab.iconRes() = when (this) {
    MainBottomTab.HOME -> Res.drawable.ic_home
    MainBottomTab.SETTING -> Res.drawable.ic_setting
}

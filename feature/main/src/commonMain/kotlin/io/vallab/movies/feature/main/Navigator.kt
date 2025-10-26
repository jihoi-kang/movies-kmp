package io.vallab.movies.feature.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navOptions
import io.vallab.movies.core.navigation.MainTabRoute
import io.vallab.movies.core.navigation.Route

class Navigator(
    val navController: NavHostController,
    val initTab: MainBottomTab = MainBottomTab.HOME,
) {

    val selectedTab: MainBottomTab?
        @Composable get() = MainBottomTab.entries.find {
            it.route()
                .has()
        }

    val bottomBarVisible: Boolean
        @Composable get() = MainBottomTab.entries.map { it.route() }
            .any { it.has() }

    fun navigate(route: Route) {
        navController.navigate(route, getNavOptions(route))
    }

    private fun getNavOptions(route: Route): NavOptions? = if (route is MainTabRoute) {
        navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    } else {
        null
    }

    @Composable
    private fun Route.has(): Boolean =
        navController.currentBackStackEntryAsState().value?.destination?.hasRoute(this::class) == true

}

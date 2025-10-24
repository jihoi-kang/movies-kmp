package io.vallab.movies.feature.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import io.vallab.movies.core.designsystem.theme.VallabTheme
import io.vallab.movies.core.navigation.Route
import io.vallab.movies.feature.main.component.MainBottomBar
import io.vallab.movies.feature.main.component.MainNavHost

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = VallabTheme.colorScheme.background,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            MainNavHost(navController = navController)
            MainBottomBar(
                onClickHome = {
                    val navOptions = navOptions {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    navController.navigate(Route.Home, navOptions)
                },
                onClickSetting = {
                    val navOptions = navOptions {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                    navController.navigate(Route.Setting, navOptions)
                },
            )
        }
    }
}

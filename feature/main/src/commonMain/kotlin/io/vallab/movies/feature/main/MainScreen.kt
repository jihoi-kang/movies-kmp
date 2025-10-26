package io.vallab.movies.feature.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import io.vallab.movies.core.designsystem.theme.VallabTheme
import io.vallab.movies.feature.main.component.MainBottomBar
import io.vallab.movies.feature.main.component.MainNavHost

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val navigator = remember(navController) { Navigator(navController) }

    Surface(
        modifier = modifier.fillMaxSize(),
        color = VallabTheme.colorScheme.background,
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            MainNavHost(navigator = navigator)

            MainBottomBar(
                visible = navigator.bottomBarVisible,
                selectedTab = navigator.selectedTab,
                onSelectTab = { navigator.navigate(it.route()) },
            )
        }
    }
}

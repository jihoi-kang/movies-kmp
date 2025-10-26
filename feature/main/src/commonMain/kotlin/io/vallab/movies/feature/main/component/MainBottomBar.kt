package io.vallab.movies.feature.main.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import io.vallab.movies.core.designsystem.theme.VallabTheme
import io.vallab.movies.feature.main.MainBottomTab
import io.vallab.movies.feature.main.iconRes
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun BoxScope.MainBottomBar(
    modifier: Modifier = Modifier,
    visible: Boolean,
    selectedTab: MainBottomTab?,
    onSelectTab: (MainBottomTab) -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + slideIn { IntOffset(0, it.height) },
        exit = fadeOut() + slideOut { IntOffset(0, it.height) },
        modifier = Modifier.align(Alignment.BottomCenter)
            .navigationBarsPadding(),
    ) {
        Surface(
            shape = CircleShape,
            border = BorderStroke(1.dp, VallabTheme.colorScheme.borderColor),
            color = VallabTheme.colorScheme.surface,
            modifier = modifier.padding(8.dp)
                .fillMaxWidth()
                .height(56.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
                    .selectableGroup(),
            ) {
                MainBottomTab.entries.forEach { tab ->
                    MainBottomTabItem(
                        tab = tab,
                        selected = tab == selectedTab,
                        onSelectTab = onSelectTab,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
        }
    }
}

@Composable
private fun MainBottomTabItem(
    modifier: Modifier,
    tab: MainBottomTab,
    selected: Boolean,
    onSelectTab: (MainBottomTab) -> Unit,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxHeight()
            .selectable(
                selected = selected,
                role = Role.Tab,
                onClick = { onSelectTab(tab) },
            ),
    ) {
        Icon(
            painter = painterResource(tab.iconRes()),
            contentDescription = tab.name,
            tint = if (selected) VallabTheme.colorScheme.selectedIconColor else VallabTheme.colorScheme.unselectedIconColor,
            modifier = Modifier.size(32.dp),
        )
    }
}

@Preview
@Composable
private fun MainBottomBarPreview() {
    VallabTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            var show by remember { mutableStateOf(true) }
            var selectedTab by remember { mutableStateOf(MainBottomTab.HOME) }

            Button(
                onClick = { show = !show },
                modifier = Modifier.align(Alignment.Center),
            ) {
                Text(text = "show/hide")
            }

            MainBottomBar(
                visible = show,
                selectedTab = selectedTab,
                onSelectTab = { selectedTab = it },
            )
        }
    }
}

package io.vallab.movies.feature.main.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import io.vallab.movies.core.designsystem.theme.VallabTheme

@Composable
fun BoxScope.MainBottomBar(
    modifier: Modifier = Modifier,
    onClickHome: () -> Unit,
    onClickSetting: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier.fillMaxWidth()
            .align(Alignment.BottomCenter)
            .background(color = VallabTheme.colorScheme.secondarySurface)
            .navigationBarsPadding(),
    ) {
        Text(text = "Home", modifier = Modifier.clickable { onClickHome() })
        Text(text = "Setting", modifier = Modifier.clickable { onClickSetting() })
    }
}

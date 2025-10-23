package io.vallab.movies.core.designsystem.theme

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontFamily
import coil3.ColorImage
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.AsyncImagePreviewHandler
import coil3.compose.LocalAsyncImagePreviewHandler

@OptIn(ExperimentalCoilApi::class)
@Composable
fun VallabTheme(
    fontFamily: FontFamily = FontFamily.Default,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalDarkTheme provides darkTheme,
        LocalColorScheme provides if (darkTheme) VallabColorScheme.darkColorScheme else VallabColorScheme.lightColorScheme,
        LocalIndication provides ripple(),
        LocalTypography provides VallabTypography.with(fontFamily = fontFamily),
        LocalAsyncImagePreviewHandler provides AsyncImagePreviewHandler {
            ColorImage(Color.Red.toArgb())
        },
        content = content,
    )
}

object VallabTheme {

    val colorScheme: VallabColorScheme
        @Composable @ReadOnlyComposable get() = LocalColorScheme.current

    val typography: VallabTypography
        @Composable @ReadOnlyComposable get() = LocalTypography.current

}

val LocalDarkTheme = compositionLocalOf { true }

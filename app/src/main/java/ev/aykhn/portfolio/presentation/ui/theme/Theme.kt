package ev.aykhn.portfolio.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Primary1,
    primaryVariant = Primary2,
    secondary = Secondary1,
    secondaryVariant = Secondary2,
    background = Vulcan1,
    surface = Vulcan2,
    onPrimary = White1,
    onSecondary = Black,
    onBackground = White1,
    onSurface = White1,
)

@Composable
fun PortfolioTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    // only dark theme
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
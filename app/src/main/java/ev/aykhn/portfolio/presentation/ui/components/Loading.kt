package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ev.aykhn.portfolio.presentation.ui.theme.PortfolioTheme
import ev.aykhn.portfolio.presentation.ui.theme.Primary4
import ev.aykhn.portfolio.presentation.ui.theme.paddingDefault

@Composable
fun LoadableUIComponent(
    isLoading: Boolean,
    content: @Composable () -> Unit,
) {
    if (isLoading) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = paddingDefault),
            contentAlignment = Alignment.Center,
        ) {
            CircularProgressIndicator(color = Primary4)
        }
    }
    AnimatedVisibility(visible = !isLoading, enter = fadeIn() + slideInHorizontally(), exit = fadeOut()) {
        content()
    }
}

@Preview
@Composable
fun LoadableUIComponent() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            LoadableUIComponent(isLoading = true) {

            }
        }
    }
}
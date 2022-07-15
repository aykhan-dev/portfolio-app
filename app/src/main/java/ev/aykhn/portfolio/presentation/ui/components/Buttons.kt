package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.ui.theme.PortfolioTheme
import ev.aykhn.portfolio.presentation.ui.theme.Primary1
import ev.aykhn.portfolio.presentation.ui.theme.White1

@Composable
fun FlatBlueButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    TextButton(
        onClick = onClick,
        modifier = modifier.heightIn(min = 52.dp),
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = Primary1
        ),
        shape = MaterialTheme.shapes.medium
    ) {
        content()
    }
}

@Preview
@Composable
fun FlatBlueButtonPreview() {
    PortfolioTheme {
        FlatBlueButton(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Hire me", color = White1)
        }
    }
}
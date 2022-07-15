package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ev.aykhn.portfolio.domain.uiModel.StatUI
import ev.aykhn.portfolio.presentation.ui.theme.Aluminium1
import ev.aykhn.portfolio.presentation.ui.theme.PortfolioTheme
import ev.aykhn.portfolio.presentation.ui.theme.paddingNormal

@Composable
fun Stat(
    stat: StatUI,
    modifier: Modifier = Modifier,
    textAlign: TextAlign = TextAlign.Start,
) {
    Column(modifier = modifier) {
        Text(
            text = stat.indicator,
            textAlign = textAlign,
            style = MaterialTheme.typography.h4,
            modifier = Modifier.fillMaxWidth(),
        )
        Text(
            text = stat.description,
            textAlign = textAlign,
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
            modifier = Modifier.padding(top = paddingNormal),
        )
    }
}

@Preview
@Composable
fun StatPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            StatUI(
                indicator = "50%",
                description = "One repays a teacher badly if one remains only a pupil.",
            )
        }
    }
}
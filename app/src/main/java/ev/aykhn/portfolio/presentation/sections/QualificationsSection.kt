package ev.aykhn.portfolio.presentation.sections

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
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun QualificationsSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault, vertical = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        //TODO move to strings.xml
        Text(
            text = "What makes me who I am.",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h4,
        )
        //TODO move to strings.xml
        Text(
            text = "First, you must see your attempt at attaining mastery as something extremely necessary and positive.",
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = paddingNormal)
        )
    }
}

@Preview
@Composable
fun QualificationsSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            QualificationsSection()
        }
    }
}
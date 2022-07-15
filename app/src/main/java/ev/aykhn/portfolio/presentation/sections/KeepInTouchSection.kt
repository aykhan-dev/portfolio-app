package ev.aykhn.portfolio.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.ui.components.FlatBlueButton
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun KeepInTouchSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault, vertical = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        //TODO move to strings.xml
        Text(
            text = "If we keep practicing, we gain fluency; basic skills are mastered, allowing us to take on newer and more exciting challenges.",
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
        )
        FlatBlueButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = paddingLarge)
                .widthIn(min = 145.dp)
        ) {
            Text(
                text = "Get In Touch",
                color = MaterialTheme.colors.onSurface,
            )
        }
        //TODO move to strings.xml
        Text(
            text = "How about we make something awesome together?",
            style = MaterialTheme.typography.h4,
            modifier = Modifier.padding(top = 60.dp)
        )
    }
}

@Preview
@Composable
fun KeepInTouchSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            KeepInTouchSection()
        }
    }
}
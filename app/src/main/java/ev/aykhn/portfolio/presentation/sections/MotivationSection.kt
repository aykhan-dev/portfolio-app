package ev.aykhn.portfolio.presentation.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun MotivationSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault, vertical = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.image_motivation),
            contentDescription = "",
            modifier = Modifier
                .padding(bottom = 60.dp)
                .fillMaxWidth()
                .aspectRatio(350f / 400f)
                .clip(MaterialTheme.shapes.medium),
        )
        //TODO move to strings.xml
        Text(
            text = "My main goal is too keep my customers satisfied.",
            style = MaterialTheme.typography.h4,
        )
        //TODO move to strings.xml
        Text(
            text = "Even with skills that are primarily mental, such as computer programming or speaking a foreign language.\n\nEven with skills that are primarily mental, such as computer programming or speaking a foreign language.",
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
            modifier = Modifier.padding(top = paddingNormal)
        )
    }
}

@Preview
@Composable
fun MotivationSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            MotivationSection()
        }
    }
}
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
fun WorkExperienceSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault, vertical = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        //TODO move to strings.xml
        Text(
            text = "I build products for companies & startups.",
            style = MaterialTheme.typography.h4,
        )
        //TODO move to strings.xml
        Text(
            text = "Everything in nature has a structure, a way that the parts relate to one another, which is generally fluid and not so easy to conceptualize.\n\n Everything in nature has a structure, a way that the parts relate to one another, which is generally fluid and not so easy to conceptualize.",
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
            modifier = Modifier.padding(top = paddingNormal)
        )
        Image(
            painter = painterResource(id = R.drawable.image_workspace),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 48.dp)
                .fillMaxWidth()
                .aspectRatio(350f / 400f)
                .clip(MaterialTheme.shapes.medium),
        )
    }
}

@Preview
@Composable
fun WorkExperienceSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            WorkExperienceSection()
        }
    }
}

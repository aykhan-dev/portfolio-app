package ev.aykhn.portfolio.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun ArticlesSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault)
            .padding(top = 90.dp, bottom = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        //TODO move to strings.xml
        Text(
            text = "Latest articles",
            style = MaterialTheme.typography.h4,
        )
        //TODO move to strings.xml
        Text(
            text = "Repeated failure will toughen your spirit and show you with absolute clarity how things must be done.",
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
            modifier = Modifier.padding(top = paddingNormal)
        )
    }
}

@Preview
@Composable
fun ArticlesSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            ArticlesSection()
        }
    }
}

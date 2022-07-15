package ev.aykhn.portfolio.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ev.aykhn.portfolio.presentation.Router
import ev.aykhn.portfolio.presentation.ui.components.FlatBlueButton
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun HireMeSection(navHostController: NavHostController? = null) {
    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault)
            .padding(top = 90.dp, bottom = 30.dp)
            .fillMaxWidth()
    ) {
        //TODO move to strings.xml
        Text(
            text = buildAnnotatedString {
                append("Mobile ")
                withStyle(SpanStyle(color = Aluminium1)) {
                    append("Software ")
                }
                append("Engineer")
                withStyle(SpanStyle(color = Primary4)) {
                    append(".")
                }
            },
            style = MaterialTheme.typography.h3,
        )
        //TODO move to strings.xml
        Text(
            text = "I am Aykhan, senior Mobile Software Engineer based on Baku. \n" +
                    "I am here to help you build your amazing product.",
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
            modifier = Modifier.padding(top = paddingNormal)
        )
        FlatBlueButton(
            onClick = {
                navHostController?.navigate(Router.SCREEN_ABOUT_ME)
            },
            modifier = Modifier
                .padding(top = paddingDefault)
                .fillMaxWidth()
        ) {
            //TODO move to strings.xml
            Text(
                text = "Hire Me",
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Preview
@Composable
fun HireMeSectionPreview() {
    PortfolioTheme {
        Surface {
            HireMeSection()
        }
    }
}
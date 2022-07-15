package ev.aykhn.portfolio.presentation.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun ProfileSection() {
    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault)
            .padding(top = 90.dp, bottom = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        ConstraintLayout {
            val (image, title) = createRefs()

            Image(
                painter = painterResource(id = R.drawable.image_profile),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(350f / 400f)
                    .constrainAs(image) { },
            )
            //TODO move to strings.xml
            Text(
                text = buildAnnotatedString {
                    append("I'm senior Mobile Software Engineer ")
                    withStyle(SpanStyle(color = Aluminium1)) {
                        append("based ")
                    }
                    append("in Baku")
                    withStyle(SpanStyle(color = Primary4)) {
                        append(".")
                    }
                },
                style = MaterialTheme.typography.h3,
                modifier = Modifier.constrainAs(title) {
                    top.linkTo(image.bottom)
                    bottom.linkTo(image.bottom)
                }
            )
        }
        //TODO move to strings.xml
        Text(
            text = "Become who you are by learning who you are.",
            style = MaterialTheme.typography.body1,
            color = Aluminium1,
            modifier = Modifier.padding(top = paddingNormal)
        )
        Row(
            modifier = Modifier.padding(top = 48.dp).fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "LinkedIn",
                style = MaterialTheme.typography.caption,
            )
            Text(
                text = "Github",
                style = MaterialTheme.typography.caption,
            )
            Text(
                text = "Email",
                style = MaterialTheme.typography.caption,
            )
            Text(
                text = "Facebook",
                style = MaterialTheme.typography.caption,
            )
        }
    }
}

@Preview
@Composable
fun ProfileSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            ProfileSection()
        }
    }
}
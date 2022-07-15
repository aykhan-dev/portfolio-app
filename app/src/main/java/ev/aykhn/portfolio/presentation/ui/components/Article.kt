@file:OptIn(ExperimentalMaterialApi::class)

package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.presentation.ui.theme.*

enum class ArticleViewType {
    Flat, Colored
}

@Composable
fun Article(modifier: Modifier = Modifier, onClick: () -> Unit, viewType: ArticleViewType ) {
    val backgroundColor = if (viewType == ArticleViewType.Flat) Color.Transparent else Vulcan2

    Card(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        backgroundColor = backgroundColor,
        shape = MaterialTheme.shapes.medium,
        elevation = 0.dp,
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.image_workspace),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(350f / 316f)
            )
            Column(modifier = Modifier.padding(paddingMedium)) {
                //TODO move to strings.xml
                Text(
                    text = "How to design an app from stratch",
                    style = MaterialTheme.typography.body1Bold,
                )
                //TODO move to strings.xml
                Text(
                    text = "You must engrave deeply in your mind and never forget: your emotional commitment to what you are doing will be translated into your work.",
                    style = MaterialTheme.typography.caption,
                    color = Aluminium1,
                    maxLines = 4,
                    softWrap = true,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.padding(top = paddingNormal),
                )
                Row(
                    modifier = Modifier.padding(top = paddingLarge),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    //TODO move to strings.xml
                    Text(
                        text = "Read full post",
                        style = MaterialTheme.typography.captionBold,
                        color = Primary1,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.ic_next),
                        contentDescription = "",
                        tint = Primary1,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun FlatArticlePreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            Article(viewType = ArticleViewType.Flat, onClick = {})
        }
    }
}

@Preview
@Composable
fun ColoredArticlePreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            Article(viewType = ArticleViewType.Colored, onClick = {})
        }
    }
}
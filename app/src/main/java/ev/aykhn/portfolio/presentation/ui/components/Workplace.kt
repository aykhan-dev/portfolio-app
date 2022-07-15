package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.domain.uiModel.WorkplaceUI
import ev.aykhn.portfolio.presentation.ui.theme.*

enum class WorkplaceViewType {
    Flat, Colored
}

@Composable
fun Workplace(
    workplace: WorkplaceUI,
    viewType: WorkplaceViewType,
    modifier: Modifier = Modifier,
) {
    val backgroundColor = if (viewType == WorkplaceViewType.Flat) Color.Transparent else Vulcan2

    val logoBackgroundColor = if (viewType == WorkplaceViewType.Flat) Vulcan2 else Primary4
    val logoTint = if (viewType == WorkplaceViewType.Flat) White1 else Vulcan1

    Card(
        backgroundColor = backgroundColor,
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.fillMaxWidth(),
        elevation = 0.dp,
    ) {
        Row(modifier = Modifier.padding(paddingMedium)) {
            Image(
                painter = painterResource(id = R.drawable.ic_hashtag),
                contentDescription = "",
                contentScale = ContentScale.Inside,
                modifier = Modifier
                    .size(44.dp)
                    .clip(CircleShape)
                    .background(logoBackgroundColor),
                colorFilter = ColorFilter.tint(color = logoTint),
            )
            Column(modifier = Modifier.padding(start = paddingLarge)) {
                Text(text = workplace.name, style = MaterialTheme.typography.body1Bold)
                Text(
                    text = workplace.role,
                    style = MaterialTheme.typography.caption2,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun FlatWorkplacePreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            Workplace(
                workplace = WorkplaceUI("Reddit", "Senior Software Engineer", ""),
                viewType = WorkplaceViewType.Flat,
            )
        }
    }
}

@Preview
@Composable
fun ColoredWorkplacePreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            Workplace(
                workplace = WorkplaceUI("Reddit", "Senior Software Engineer", ""),
                viewType = WorkplaceViewType.Colored,
            )
        }
    }
}
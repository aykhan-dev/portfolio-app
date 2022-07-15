package ev.aykhn.portfolio.presentation.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.screens.SectionalScreen
import ev.aykhn.portfolio.presentation.sections.ArticlesSection
import ev.aykhn.portfolio.presentation.sections.SubscriptionSection
import ev.aykhn.portfolio.presentation.ui.components.Article
import ev.aykhn.portfolio.presentation.ui.components.ArticleViewType
import ev.aykhn.portfolio.presentation.ui.theme.paddingDefault

@Composable
fun BlogScreen() {
    SectionalScreen {
        item { SubscriptionSection() }
        item { ArticlesSection() }
        // can be paginated
        items(4) { index ->
            Article(
                onClick = { /*TODO*/ },
                viewType = if ((index + 1) % 2 == 0) ArticleViewType.Colored else ArticleViewType.Flat,
                modifier = Modifier
                    .padding(horizontal = paddingDefault)
                    .padding(
                        top = if (index == 0) 48.dp else 0.dp,
                        bottom = if (index != 3) 32.dp else 45.dp,
                    ),
            )
        }
    }
}
@file:OptIn(ExperimentalMaterialApi::class)

package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.Router
import ev.aykhn.portfolio.presentation.ui.theme.*

private fun getLabelOfRoute(route: String): String {
    return route.removePrefix("/").replace("_", " ").capitalize()
}

@Composable
fun DrawerItem(
    route: String,
    isSelected: Boolean,
    onClick: (route: String) -> Unit,
) {
    val backgroundColor by animateColorAsState(targetValue = if (isSelected) Vulcan2 else Color.Transparent)
    val textColor by animateColorAsState(targetValue = if (isSelected) White1 else Aluminium1)

    Card(
        onClick = {
            onClick(route)
        },
        backgroundColor = backgroundColor,
        shape = RectangleShape,
        elevation = 0.dp,
    ) {
        Text(
            text = getLabelOfRoute(route),
            color = textColor,
            style = MaterialTheme.typography.button,
            modifier = Modifier
                .padding(vertical = paddingNormal, horizontal = paddingDefault)
                .fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun SelectedDrawerItemPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            DrawerItem(route = Router.SCREEN_STORYBOARD, isSelected = true) {

            }
        }
    }
}

@Preview
@Composable
fun UnselectedDrawerItemPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            DrawerItem(route = Router.SCREEN_BLOG, isSelected = false) {

            }
        }
    }
}
package ev.aykhn.portfolio.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun AppBar(onMenuClicked: () -> Unit) {
    Row(
        modifier = Modifier
            .heightIn(min = heightAppBar)
            .fillMaxWidth()
            .padding(horizontal = paddingDefault),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.vector_logo),
                contentDescription = "logo",
                contentScale = ContentScale.Inside,
                modifier = Modifier.size(32.dp)
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = stringResource(R.string.portfolio),
                style = MaterialTheme.typography.appBar,
            )
        }
        IconButton(onClick = onMenuClicked) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "Menu button",
            )
        }
    }
}

@Preview
@Composable
fun AppBarPreview() {
    PortfolioTheme {
        Surface {
            AppBar {

            }
        }
    }
}
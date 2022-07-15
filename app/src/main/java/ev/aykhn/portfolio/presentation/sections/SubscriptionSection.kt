@file:OptIn(ExperimentalComposeUiApi::class)

package ev.aykhn.portfolio.presentation.sections

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.ui.components.FlatBlueButton
import ev.aykhn.portfolio.presentation.ui.theme.*

@Composable
fun SubscriptionSection() {
    val localFocusManager = LocalFocusManager.current
    val keyboardController = LocalSoftwareKeyboardController.current

    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault)
            .padding(top = 90.dp, bottom = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        //TODO move to strings.xml
        Text(
            text = "Find tips about the best design practices",
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3,
        )
        //TODO move to strings.xml
        Text(
            text = "Everything in nature has a structure, a way that the parts relate to one another, which is generally fluid and not so easy to conceptualize.",
            style = MaterialTheme.typography.body1,
            color = Aluminium1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = paddingNormal)
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier
                .padding(top = 48.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            textStyle = MaterialTheme.typography.caption,
            placeholder = {
                //TODO move to strings.xml
                Text(
                    text = "Your email address",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onBackground,
                )
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            keyboardActions = KeyboardActions(
                onDone = {
                    localFocusManager.clearFocus()
                    keyboardController?.hide()
                }
            )
        )
        FlatBlueButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(top = paddingSmall)
                .fillMaxWidth()
        ) {
            //TODO move to strings.xml
            Text(
                text = "Subscribe",
                color = MaterialTheme.colors.onSurface
            )
        }
    }
}

@Preview
@Composable
fun SubscriptionSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            SubscriptionSection()
        }
    }
}

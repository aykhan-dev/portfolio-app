package ev.aykhn.portfolio.presentation.sections.workplaces

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.ui.components.LoadableUIComponent
import ev.aykhn.portfolio.presentation.ui.components.Workplace
import ev.aykhn.portfolio.presentation.ui.components.WorkplaceViewType
import ev.aykhn.portfolio.presentation.ui.theme.*
import org.koin.androidx.compose.koinViewModel

@Composable
fun WorkplacesSection(vm: WorkplacesSectionViewModel = koinViewModel()) {
    val uiState by vm.state.collectAsState()
    val workplaces = uiState.workplaces

    DisposableEffect(key1 = vm) {
        vm.onEvent(WorkplacesSectionEvent.LoadWorkplaces)
        onDispose { }
    }

    Column(
        modifier = Modifier
            .padding(horizontal = paddingDefault, vertical = paddingVerticalInnerSection)
            .fillMaxWidth()
    ) {
        //TODO move to strings.xml
        Text(
            text = "Companies I have worked with.",
            style = MaterialTheme.typography.h4,
        )
        //TODO move to strings.xml
        Text(
            text = "This means that you move toward challenges that will toughen and improve you, where you will get the most objective feedback on your performance and progress. You do not choose apprenticeships that seem easy and comfortable\n\n" +
                    "One can have no smaller or greater mastery than mastery of oneself.",
            style = MaterialTheme.typography.body2,
            color = Aluminium1,
            modifier = Modifier.padding(top = paddingNormal)
        )
        LoadableUIComponent(isLoading = uiState.isLoading) {
            Column {
                workplaces.forEachIndexed { index, workplace ->
                    val viewType =
                        if ((index + 1) % 2 == 0) WorkplaceViewType.Colored else WorkplaceViewType.Flat

                    Workplace(
                        workplace = workplace,
                        viewType = viewType,
                        modifier = Modifier.padding(
                            top = if (index == 0) 48.dp else 0.dp,
                            bottom = if (index != 2) 32.dp else paddingVerticalInnerSection
                        )
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun WorkplacesSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            WorkplacesSection()
        }
    }
}
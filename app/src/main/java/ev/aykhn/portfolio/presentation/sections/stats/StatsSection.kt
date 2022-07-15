package ev.aykhn.portfolio.presentation.sections.stats

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.public.StatsSectionEvent
import ev.aykhn.portfolio.presentation.ui.components.LoadableUIComponent
import ev.aykhn.portfolio.presentation.ui.components.Stat
import ev.aykhn.portfolio.presentation.ui.theme.PortfolioTheme
import ev.aykhn.portfolio.presentation.ui.theme.paddingDefault
import ev.aykhn.portfolio.presentation.ui.theme.paddingVerticalInnerSection
import org.koin.androidx.compose.getViewModel

enum class StatsSectionType {
    HOME, ABOUT_ME
}

@Composable
fun StatsSection(sectionType: StatsSectionType) {
    val showTitle = sectionType == StatsSectionType.HOME
    val textAlign = if(showTitle) TextAlign.Start else TextAlign.Center

    val vm = getViewModel<StatsSectionViewModel>()
    val uiState by vm.state.collectAsState()
    val stats = uiState.stats

    DisposableEffect(key1 = vm) {
        vm.onEvent(StatsSectionEvent.LoadStats)
        onDispose { }
    }

    LoadableUIComponent(isLoading = uiState.isLoading) {
        Column(
            modifier = Modifier
                .padding(horizontal = paddingDefault, vertical = paddingVerticalInnerSection)
                .fillMaxWidth()
        ) {
            if (showTitle) {
                //TODO move to strings.xml
                Text(
                    text = "I’ve worked with tech companies, government, banks, social media companies & startups around the world",
                    style = MaterialTheme.typography.h4,
                )
            }
            stats.forEachIndexed { index, stat ->
                Stat(
                    stat = stat,
                    textAlign = textAlign,
                    modifier = Modifier
                        .padding(top = if(index == 0 && showTitle) 48.dp else 0.dp)
                        .padding(bottom = if (index == stats.lastIndex) 0.dp else 35.dp)
                )
            }
        }
    }
}

@Preview
@Composable
fun OverallStatsSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            StatsSection(sectionType = StatsSectionType.HOME)
        }
    }
}
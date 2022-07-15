package ev.aykhn.portfolio.presentation.sections.skills

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ev.aykhn.portfolio.presentation.public.SkillsSectionEvent
import ev.aykhn.portfolio.presentation.ui.components.LoadableUIComponent
import ev.aykhn.portfolio.presentation.ui.components.SkillCard
import ev.aykhn.portfolio.presentation.ui.components.SkillCardType
import ev.aykhn.portfolio.presentation.ui.theme.PortfolioTheme
import ev.aykhn.portfolio.presentation.ui.theme.paddingDefault
import ev.aykhn.portfolio.presentation.ui.theme.paddingVerticalInnerSection
import org.koin.androidx.compose.getViewModel

enum class SkillsSectionType {
    HARD, SOFT
}

@Composable
fun SkillsSection(sectionType: SkillsSectionType) {
    val vm = when (sectionType) {
        SkillsSectionType.HARD -> getViewModel<HardSkillsSectionViewModel>()
        SkillsSectionType.SOFT -> getViewModel<SoftSkillsSectionViewModel>()
    }
    val uiState by vm.state.collectAsState()
    val skills = uiState.skills

    DisposableEffect(key1 = vm) {
        vm.onEvent(SkillsSectionEvent.LoadSkills)
        onDispose { }
    }

    LoadableUIComponent(isLoading = uiState.isLoading) {
        Column(
            modifier = Modifier
                .padding(horizontal = paddingDefault, vertical = 30.dp)
                .fillMaxWidth()
        ) {
            skills.forEachIndexed { index, skill ->
                val cardType = if ((index + 1) % 2 == 0) SkillCardType.Colored else SkillCardType.Flat
                val hasTopMargin = index == 0 && sectionType == SkillsSectionType.HARD
                val hasBottomMargin = index == skills.lastIndex

                SkillCard(
                    skill = skill,
                    skillCardType = cardType,
                    modifier = Modifier.padding(
                        top = if (hasTopMargin) 48.dp else 0.dp,
                        bottom = if (hasBottomMargin) paddingVerticalInnerSection else 32.dp
                    )
                )
            }
        }
    }
}

@Preview
@Composable
fun SkillsSectionPreview() {
    PortfolioTheme {
        Surface(color = MaterialTheme.colors.background) {
            SkillsSection(SkillsSectionType.HARD)
        }
    }
}
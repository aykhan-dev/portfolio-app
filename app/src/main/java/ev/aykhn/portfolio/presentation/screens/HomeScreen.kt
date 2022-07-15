package ev.aykhn.portfolio.presentation.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ev.aykhn.portfolio.presentation.sections.HireMeSection
import ev.aykhn.portfolio.presentation.sections.MotivationSection
import ev.aykhn.portfolio.presentation.sections.WorkExperienceSection
import ev.aykhn.portfolio.presentation.sections.stats.StatsSection
import ev.aykhn.portfolio.presentation.sections.stats.StatsSectionType
import ev.aykhn.portfolio.presentation.sections.skills.SkillsSection
import ev.aykhn.portfolio.presentation.sections.skills.SkillsSectionType

@Composable
fun HomeScreen(navHostController: NavHostController) {
    SectionalScreen {
        item { HireMeSection(navHostController) }
        item { SkillsSection(sectionType = SkillsSectionType.HARD) }
        item { WorkExperienceSection() }
        item { StatsSection(sectionType = StatsSectionType.HOME) }
        item { MotivationSection() }
    }
}
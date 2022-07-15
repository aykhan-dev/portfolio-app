package ev.aykhn.portfolio.presentation.screens

import androidx.compose.runtime.Composable
import ev.aykhn.portfolio.presentation.sections.ProfileSection
import ev.aykhn.portfolio.presentation.sections.QualificationsSection
import ev.aykhn.portfolio.presentation.sections.skills.SkillsSection
import ev.aykhn.portfolio.presentation.sections.skills.SkillsSectionType
import ev.aykhn.portfolio.presentation.sections.stats.StatsSection
import ev.aykhn.portfolio.presentation.sections.stats.StatsSectionType
import ev.aykhn.portfolio.presentation.sections.workplaces.WorkplacesSection

@Composable
fun AboutMeScreen() {
    SectionalScreen {
        item { ProfileSection() }
        item { QualificationsSection() }
        item { SkillsSection(sectionType = SkillsSectionType.SOFT) }
        item { StatsSection(sectionType = StatsSectionType.ABOUT_ME) }
        item { WorkplacesSection() }
    }
}
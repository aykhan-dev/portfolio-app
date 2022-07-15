package ev.aykhn.portfolio.presentation.di

import ev.aykhn.portfolio.presentation.sections.skills.HardSkillsSectionViewModel
import ev.aykhn.portfolio.presentation.sections.skills.SoftSkillsSectionViewModel
import ev.aykhn.portfolio.presentation.sections.stats.StatsSectionViewModel
import ev.aykhn.portfolio.presentation.sections.workplaces.WorkplacesSectionViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    viewModelOf(::StatsSectionViewModel)

    viewModelOf(::HardSkillsSectionViewModel)
    viewModelOf(::SoftSkillsSectionViewModel)

    viewModelOf(::WorkplacesSectionViewModel)

}
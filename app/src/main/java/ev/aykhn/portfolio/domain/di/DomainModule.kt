package ev.aykhn.portfolio.domain.di

import ev.aykhn.portfolio.domain.usecase.SkillsUseCase.LoadHardSkills
import ev.aykhn.portfolio.domain.usecase.SkillsUseCase.LoadSoftSkills
import ev.aykhn.portfolio.domain.usecase.StatsUseCase.LoadStats
import ev.aykhn.portfolio.domain.usecase.LoadWorkplaces
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {

    singleOf(::LoadWorkplaces)

    singleOf(::LoadHardSkills)
    singleOf(::LoadSoftSkills)

    singleOf(::LoadStats)

}
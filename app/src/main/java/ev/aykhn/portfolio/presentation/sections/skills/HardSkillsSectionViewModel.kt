package ev.aykhn.portfolio.presentation.sections.skills

import ev.aykhn.portfolio.domain.usecase.SkillsUseCase
import ev.aykhn.portfolio.presentation.public.SkillsSectionState
import ev.aykhn.portfolio.presentation.public.SkillsSectionViewModel

class HardSkillsSectionViewModel(
    private val loadHardSkills: SkillsUseCase.LoadHardSkills
) : SkillsSectionViewModel() {

    override fun provideInitialState(): SkillsSectionState = SkillsSectionState()

    override fun loadSkills() {
        loadHardSkills.useCase(Unit) { data ->
            emitState(
                state = SkillsSectionState(
                    isLoading = false,
                    skills = data,
                )
            )
        }
    }

}
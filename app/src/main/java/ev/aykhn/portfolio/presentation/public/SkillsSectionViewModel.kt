package ev.aykhn.portfolio.presentation.public

import ev.aykhn.portfolio.domain.uiModel.SkillUI
import ev.aykhn.portfolio.presentation.base.BaseViewModel

abstract class SkillsSectionViewModel: BaseViewModel<SkillsSectionState, Nothing, SkillsSectionEvent>() {
    override fun onEvent(event: SkillsSectionEvent) {
        when(event) {
            is SkillsSectionEvent.LoadSkills -> loadSkills()
        }
    }

    abstract fun loadSkills()
}

data class SkillsSectionState(
    val isLoading: Boolean = true,
    val skills: List<SkillUI> = emptyList(),
)

sealed class SkillsSectionEvent {
    object LoadSkills: SkillsSectionEvent()
}
package ev.aykhn.portfolio.presentation.sections.skills

import ev.aykhn.portfolio.R
import ev.aykhn.portfolio.domain.uiModel.SkillUI
import ev.aykhn.portfolio.domain.usecase.SkillsUseCase
import ev.aykhn.portfolio.presentation.public.SkillsSectionState
import ev.aykhn.portfolio.presentation.public.SkillsSectionViewModel

class SoftSkillsSectionViewModel(
    private val loadSoftSkills: SkillsUseCase.LoadSoftSkills
) : SkillsSectionViewModel() {

    override fun provideInitialState(): SkillsSectionState = SkillsSectionState()

    override fun loadSkills() {
        loadSoftSkills.useCase(Unit) { data ->
            emitState(
                state = SkillsSectionState(
                    isLoading = false,
                    skills = data,
                )
            )
        }
        val data = listOf(
            SkillUI(
                R.drawable.ic_hashtag,
                "Passionate",
                "The time that leads to mastery is dependent on the intensity of our focus."
            ),
            SkillUI(
                R.drawable.ic_hashtag,
                "Curious",
                "The time that leads to mastery is dependent on the intensity of our focus."
            ),
            SkillUI(
                R.drawable.ic_hashtag,
                "Team Work",
                "The time that leads to mastery is dependent on the intensity of our focus."
            ),
            SkillUI(
                R.drawable.ic_hashtag,
                "Discipline",
                "The time that leads to mastery is dependent on the intensity of our focus."
            ),
            SkillUI(
                R.drawable.ic_hashtag,
                "Creative",
                "The time that leads to mastery is dependent on the intensity of our focus."
            ),
            SkillUI(
                R.drawable.ic_hashtag,
                "Compassionate",
                "The time that leads to mastery is dependent on the intensity of our focus."
            ),
        )
    }

}
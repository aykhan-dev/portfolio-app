package ev.aykhn.portfolio.domain.usecase

import ev.aykhn.portfolio.domain.base.BaseUseCase
import ev.aykhn.portfolio.domain.repository.SkillsRepository
import ev.aykhn.portfolio.domain.uiModel.SkillUI

object SkillsUseCase {

    class LoadHardSkills(
        private val repository: SkillsRepository,
    ): BaseUseCase<Unit, List<SkillUI>>() {

        override suspend fun execute(params: Unit): List<SkillUI> {
            return repository.loadHardSkills()
        }

    }

    class LoadSoftSkills(
        private val repository: SkillsRepository,
    ): BaseUseCase<Unit, List<SkillUI>>() {

        override suspend fun execute(params: Unit): List<SkillUI> {
            return repository.loadSoftSkills()
        }

    }

}
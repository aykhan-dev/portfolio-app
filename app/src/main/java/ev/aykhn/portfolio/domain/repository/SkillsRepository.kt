package ev.aykhn.portfolio.domain.repository

import ev.aykhn.portfolio.domain.uiModel.SkillUI

interface SkillsRepository {

    suspend fun loadHardSkills(): List<SkillUI>

    suspend fun loadSoftSkills(): List<SkillUI>

}
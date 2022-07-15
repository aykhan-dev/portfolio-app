package ev.aykhn.portfolio.data.repositoryImpl

import ev.aykhn.portfolio.data.dataSource.remote.SkillsRemoteDataSource
import ev.aykhn.portfolio.data.mapper.SkillMapper
import ev.aykhn.portfolio.domain.repository.SkillsRepository
import ev.aykhn.portfolio.domain.uiModel.SkillUI

class SkillsRepositoryImpl(
    private val skillsRemoteDataSource: SkillsRemoteDataSource
) : SkillsRepository {

    override suspend fun loadHardSkills(): List<SkillUI> {
        val rawData = skillsRemoteDataSource.loadHardSkills()
        return SkillMapper.toSkillUIs(rawData)
    }

    override suspend fun loadSoftSkills(): List<SkillUI> {
        val rawData = skillsRemoteDataSource.loadSoftSkills()
        return SkillMapper.toSkillUIs(rawData)
    }

}
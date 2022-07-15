package ev.aykhn.portfolio.data.repositoryImpl

import ev.aykhn.portfolio.data.dataSource.remote.WorkplacesRemoteDataSource
import ev.aykhn.portfolio.data.mapper.WorkplaceMapper
import ev.aykhn.portfolio.domain.repository.WorkplacesRepository
import ev.aykhn.portfolio.domain.uiModel.WorkplaceUI

class WorkplacesRepositoryImpl(
    private val workplacesRemoteDataSource: WorkplacesRemoteDataSource
) : WorkplacesRepository {

    override suspend fun loadWorkplaces(): List<WorkplaceUI> {
        val rawData = workplacesRemoteDataSource.getWorkplaces()
        return WorkplaceMapper.toWorkplaceUIs(rawData)
    }

}
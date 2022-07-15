package ev.aykhn.portfolio.data.repositoryImpl

import ev.aykhn.portfolio.data.dataSource.remote.StatsRemoteDataSource
import ev.aykhn.portfolio.data.mapper.StatMapper
import ev.aykhn.portfolio.domain.repository.StatsRepository
import ev.aykhn.portfolio.domain.uiModel.StatUI

class StatsRepositoryImpl(
    private val statsRemoteDataSource: StatsRemoteDataSource,
) : StatsRepository {

    override suspend fun loadStats(): List<StatUI> {
        val rawData = statsRemoteDataSource.getStats()
        return StatMapper.toStatUIs(rawData)
    }

}
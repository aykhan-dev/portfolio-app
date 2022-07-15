package ev.aykhn.portfolio.domain.repository

import ev.aykhn.portfolio.domain.uiModel.StatUI

interface StatsRepository {

    suspend fun loadStats(): List<StatUI>

}
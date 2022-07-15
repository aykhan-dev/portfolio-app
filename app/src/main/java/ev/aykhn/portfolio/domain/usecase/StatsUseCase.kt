package ev.aykhn.portfolio.domain.usecase

import ev.aykhn.portfolio.domain.base.BaseUseCase
import ev.aykhn.portfolio.domain.repository.StatsRepository
import ev.aykhn.portfolio.domain.uiModel.StatUI

object StatsUseCase {

    class LoadStats(
        private val statsRepository: StatsRepository,
    ) : BaseUseCase<Unit, List<StatUI>>() {

        override suspend fun execute(params: Unit): List<StatUI> {
            return statsRepository.loadStats()
        }

    }

}
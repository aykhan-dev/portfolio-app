package ev.aykhn.portfolio.domain.usecase

import ev.aykhn.portfolio.domain.base.BaseUseCase
import ev.aykhn.portfolio.domain.repository.WorkplacesRepository
import ev.aykhn.portfolio.domain.uiModel.WorkplaceUI

class LoadWorkplaces(
    private val workplacesRepository: WorkplacesRepository,
) : BaseUseCase<Unit, List<WorkplaceUI>>() {

    override suspend fun execute(params: Unit): List<WorkplaceUI> {
        return workplacesRepository.loadWorkplaces()
    }

}
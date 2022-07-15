package ev.aykhn.portfolio.domain.repository

import ev.aykhn.portfolio.domain.uiModel.WorkplaceUI

interface WorkplacesRepository {

    suspend fun loadWorkplaces(): List<WorkplaceUI>

}
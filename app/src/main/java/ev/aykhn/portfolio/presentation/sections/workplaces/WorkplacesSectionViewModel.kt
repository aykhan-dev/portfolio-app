package ev.aykhn.portfolio.presentation.sections.workplaces

import ev.aykhn.portfolio.domain.uiModel.WorkplaceUI
import ev.aykhn.portfolio.domain.usecase.LoadWorkplaces
import ev.aykhn.portfolio.presentation.base.BaseViewModel

class WorkplacesSectionViewModel(
    private val loadWorkplacesUseCase: LoadWorkplaces,
) : BaseViewModel<WorkplacesSectionState, Nothing, WorkplacesSectionEvent>() {

    override fun provideInitialState(): WorkplacesSectionState = WorkplacesSectionState()

    override fun onEvent(event: WorkplacesSectionEvent) {
        when (event) {
            is WorkplacesSectionEvent.LoadWorkplaces -> loadWorkplaces()
        }
    }

    private fun loadWorkplaces() {
        loadWorkplacesUseCase.useCase(Unit) { data ->
            emitState(
                state = WorkplacesSectionState(
                    isLoading = false,
                    workplaces = data,
                )
            )
        }
    }

}

data class WorkplacesSectionState(
    val isLoading: Boolean = true,
    val workplaces: List<WorkplaceUI> = emptyList()
)

sealed class WorkplacesSectionEvent {
    object LoadWorkplaces : WorkplacesSectionEvent()
}
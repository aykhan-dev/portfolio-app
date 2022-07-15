package ev.aykhn.portfolio.presentation.public

import ev.aykhn.portfolio.domain.uiModel.StatUI
import ev.aykhn.portfolio.presentation.base.BaseViewModel

abstract class StatsSectionViewModel: BaseViewModel<StatsSectionState, Nothing, StatsSectionEvent>() {

    override fun onEvent(event: StatsSectionEvent) {
        when(event) {
            is StatsSectionEvent.LoadStats -> loadStats()
        }
    }

    abstract fun loadStats()

}

data class StatsSectionState(
    val isLoading: Boolean = true,
    val stats: List<StatUI> = emptyList(),
)

sealed class StatsSectionEvent {
    object LoadStats: StatsSectionEvent()
}
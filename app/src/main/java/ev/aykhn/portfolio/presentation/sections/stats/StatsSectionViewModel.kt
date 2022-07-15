package ev.aykhn.portfolio.presentation.sections.stats

import ev.aykhn.portfolio.domain.usecase.StatsUseCase
import ev.aykhn.portfolio.presentation.public.StatsSectionState
import ev.aykhn.portfolio.presentation.public.StatsSectionViewModel

class StatsSectionViewModel(
    private val loadStats: StatsUseCase.LoadStats
) : StatsSectionViewModel() {

    override fun provideInitialState(): StatsSectionState = StatsSectionState()

    override fun loadStats() {
        loadStats.useCase(Unit) { data ->
            emitState(
                state = StatsSectionState(
                    isLoading = false,
                    stats = data,
                )
            )
        }
    }

}
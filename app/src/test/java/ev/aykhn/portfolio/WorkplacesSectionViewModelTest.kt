package ev.aykhn.portfolio

import ev.aykhn.portfolio.domain.repository.WorkplacesRepository
import ev.aykhn.portfolio.domain.usecase.LoadWorkplaces
import ev.aykhn.portfolio.presentation.sections.workplaces.WorkplacesSectionViewModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import kotlin.test.assertTrue

@RunWith(MockitoJUnitRunner::class)
class WorkplacesSectionViewModelTest {

    private lateinit var viewModel: WorkplacesSectionViewModel
    private lateinit var loadWorkplacesUseCase: LoadWorkplaces

    @Mock
    lateinit var workplacesRepository: WorkplacesRepository

    @Before
    fun setup() {
        loadWorkplacesUseCase = LoadWorkplaces(workplacesRepository)
        viewModel = WorkplacesSectionViewModel(loadWorkplacesUseCase)
    }

    @Test
    fun `should provide initial state properly`() {
        val initialState = viewModel.provideInitialState()
        assertTrue { initialState.workplaces.isEmpty() && initialState.isLoading }
    }

}
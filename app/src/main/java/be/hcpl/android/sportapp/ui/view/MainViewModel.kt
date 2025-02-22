package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.domain.model.StepPosition
import be.hcpl.android.sportapp.ui.Literals
import be.hcpl.android.sportapp.ui.model.OverviewUiModel
import be.hcpl.android.sportapp.ui.model.StepItemUiModel

class MainViewModel(
    private val literals: Literals,
) : ViewModel() {

    //private val _uiState = MutableStateFlow<UiState>(UiState(OverviewUiModel(emptyList())))
    //val uiState = _uiState.asStateFlow()
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState

    val events: MutableLiveData<UiEvent> = MutableLiveData()

    init {
        _uiState.postValue(
            UiState(
                OverviewUiModel(
                    welcomeTitle = literals.get(R.string.welcome_title),
                    welcomeText = literals.get(R.string.welcome_text),
                    steps = listOf(
                        // TODO get these from domain, including completion
                        StepPosition.HART_RATE_MONITORS.toUiModel(false),
                        StepPosition.MAX_HART_RATE.toUiModel(false),
                        StepPosition.VISUALISE_ZONES.toUiModel(false),
                        StepPosition.ABOUT.toUiModel(false),
                    )
                )
            )
        )
    }

    private fun StepPosition.toUiModel(completed: Boolean) = StepItemUiModel(
        step = this,
        label = literals.get(labelId),
        description = literals.get(descriptionId),
        completed = completed,
    )

    fun onSelect(step: StepPosition) {
        // update completion
        _uiState.value?.let { state ->
            _uiState.postValue(
                state.copy(
                    overview = state.overview?.copy(
                        steps = state.overview.steps.map { it -> if (it.step == step) it.copy(completed = true) else it }
                    )
                )
            )
        }
        // handle steps
        when (step) {
            StepPosition.HART_RATE_MONITORS -> events.postValue(UiEvent.InfoView)
            StepPosition.ABOUT -> events.postValue(UiEvent.AboutApp)
            StepPosition.NOT_SET -> TODO()
            StepPosition.MAX_HART_RATE -> events.postValue(UiEvent.MaxRate)
            StepPosition.VISUALISE_ZONES -> TODO()
        }
    }

    data class UiState(
        val overview: OverviewUiModel?,
    )

    sealed class UiEvent {
        data object InfoView : UiEvent()
        data object AboutApp : UiEvent()
        data object MaxRate : UiEvent()
    }
}
package be.hcpl.android.qwik.ui.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.domain.model.StepPosition
import be.hcpl.android.qwik.domain.storage.LocalStorage
import be.hcpl.android.qwik.ui.i18n.Literals
import be.hcpl.android.qwik.ui.model.OverviewUiModel
import be.hcpl.android.qwik.ui.model.StepItemUiModel

class MainViewModel(
    private val literals: Literals,
    private val storage: LocalStorage,
) : ViewModel() {

    // alternative approach is to use stateflow and pass viewModel to compose directly
    //private val uiState = MutableStateFlow<UiState>(UiState(OverviewUiModel(emptyList())))
    //val uiState = uiState.asStateFlow()

    val uiState: MutableLiveData<OverviewUiModel> = MutableLiveData<OverviewUiModel>()
    val events: MutableLiveData<UiEvent> = MutableLiveData()

    init {
        getInitialData()
    }

    private fun getInitialData() {
        uiState.postValue(
            OverviewUiModel(
                welcomeTitle = literals.get(R.string.welcome_title),
                welcomeText = literals.get(R.string.welcome_text),
                steps = listOf(
                    StepPosition.HART_RATE_MONITORS.toUiModel(),
                    StepPosition.MAX_HART_RATE.toUiModel(),
                    StepPosition.VISUALISE_ZONES.toUiModel(),
                    StepPosition.TRAINING_PROGRAMS.toUiModel(),
                    StepPosition.ABOUT.toUiModel(),
                )
            )
        )
    }

    private fun StepPosition.toUiModel() = StepItemUiModel(
        step = this,
        label = literals.get(labelId),
        description = literals.get(descriptionId),
        completed = storage.getBoolean(this.name),
    )

    fun onSelect(step: StepPosition) {
        // TODO don't update right away, only after entering all data required in step
        // update completion
        storage.store(step.name, true)
        // and update UI
        uiState.value?.let { state ->
            uiState.postValue(
                state.copy(
                    steps = state.steps.map { it -> if (it.step == step) it.copy(completed = true) else it }
                )
            )
        }
        // handle steps
        when (step) {
            StepPosition.HART_RATE_MONITORS -> events.postValue(UiEvent.InfoView)
            StepPosition.MAX_HART_RATE -> events.postValue(UiEvent.MaxRate)
            StepPosition.VISUALISE_ZONES -> events.postValue(UiEvent.Zones)
            StepPosition.TRAINING_PROGRAMS -> events.postValue(UiEvent.Training)
            StepPosition.ABOUT -> events.postValue(UiEvent.AboutApp)
            StepPosition.NOT_SET -> TODO()
        }
    }

    fun refresh() {
        getInitialData()
    }

    sealed class UiEvent {
        data object InfoView : UiEvent()
        data object AboutApp : UiEvent()
        data object MaxRate : UiEvent()
        data object Zones : UiEvent()
        data object Training : UiEvent()
    }
}
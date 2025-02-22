package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.domain.model.StepPosition
import be.hcpl.android.sportapp.ui.model.OverviewUiModel
import be.hcpl.android.sportapp.ui.model.StepItemUiModel
import java.lang.ref.WeakReference

class MainViewModel(
    //private val context: WeakReference<Context>,
    private val context: Context,
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
                    welcomeTitle = context.getString(R.string.welcome_title),
                    welcomeText = context.getString(R.string.welcome_text),
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
        label = context.getString(labelId),
        description = context.getString(descriptionId),
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
            else -> Unit
        }
    }

    data class UiState(
        val overview: OverviewUiModel?,
    )

    sealed class UiEvent {
        data object InfoView : UiEvent()
    }
}
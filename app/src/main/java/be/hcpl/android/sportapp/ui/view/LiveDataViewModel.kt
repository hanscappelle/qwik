package be.hcpl.android.sportapp.ui.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.ui.model.OverviewUiModel
import be.hcpl.android.sportapp.ui.model.StepItemUiModel

class LiveDataViewModel() : ViewModel() {

    // should use backing property here
    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState

    init {
        _uiState.postValue(
            UiState(
                OverviewUiModel(
                    steps = listOf(
                        StepItemUiModel(1, "test", "description", false),
                        StepItemUiModel(2, "test", "description", false),
                        StepItemUiModel(3, "test", "description", false),
                    )
                )
            )
        )
    }

    fun onSelect() {
        _uiState.postValue(
            UiState(
                OverviewUiModel(
                    steps = listOf(
                        StepItemUiModel(1, "test", "description", true),
                        StepItemUiModel(3, "test", "description", false),
                    )
                )
            )
        )
    }
}
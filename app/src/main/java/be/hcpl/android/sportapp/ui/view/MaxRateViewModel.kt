package be.hcpl.android.sportapp.ui.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.ui.screen.MaxRateUiModel
import java.util.Calendar

class MaxRateViewModel() : ViewModel() {

    val uiState: MutableLiveData<UiState> = MutableLiveData<UiState>()
    val events: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()

    init {
        uiState.postValue(
            UiState(uiModel = MaxRateUiModel())
        )
    }

    fun back() {
        events.postValue(UiEvent.Back)
    }

    fun onSelectTest() {
        uiState.value?.uiModel?.let { model ->
            uiState.postValue(
                UiState(
                    uiModel = model.copy(testVisible = !model.testVisible)
                )
            )
        }
    }

    fun onSelectCalculate() {
        uiState.value?.uiModel?.let { model ->
            uiState.postValue(
                UiState(
                    uiModel = model.copy(calculateVisible = !model.calculateVisible)
                )
            )
        }
    }

    fun onInputChanged(year: String) {
        val year: Int = year.toInt()
        val age = Calendar.getInstance().get(Calendar.YEAR) - year
        val calculatedResult = (208 - 0.7 * age).toInt()
        uiState.value?.uiModel?.let { model ->
            uiState.postValue(
                UiState(
                    uiModel = model.copy(
                        birthYear = year,
                        calculatedResult = calculatedResult,
                    )
                )
            )
        }
    }

    fun onInputMaxChanged(testValue: String) {
        uiState.value?.uiModel?.let { model ->
            uiState.postValue(
                UiState(
                    uiModel = model.copy(
                        testedMaxRate = testValue.toInt(),
                    )
                )
            )
        }
    }

    data class UiState(
        val uiModel: MaxRateUiModel,
    )

    sealed class UiEvent {
        data object Back : UiEvent()
    }
}


package be.hcpl.android.sportapp.ui.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.domain.storage.LocalStorage
import be.hcpl.android.sportapp.ui.screen.MaxRateUiModel
import java.util.Calendar

class MaxRateViewModel(
    private val storage: LocalStorage,
) : ViewModel() {

    val uiState: MutableLiveData<MaxRateUiModel> = MutableLiveData<MaxRateUiModel>()
    val events: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()

    init {
        uiState.postValue(
            MaxRateUiModel(
                calculatedResult = storage.getInt(KEY_CALCULATED_RESULT),
                testedMaxRate = storage.getInt(KEY_TESTED_RESULT),
            )
        )
    }

    fun back() {
        events.postValue(UiEvent.Back)
    }

    fun onSelectTest() {
        // update UI
        uiState.value?.let { model ->
            uiState.postValue(
                model.copy(testVisible = !model.testVisible)
            )
        }
    }

    fun onSelectCalculate() {
        uiState.value?.let { model ->
            uiState.postValue(
                model.copy(calculateVisible = !model.calculateVisible)
            )
        }
    }

    fun onInputChanged(year: Int) {
        val age = Calendar.getInstance().get(Calendar.YEAR) - year
        val calculatedResult = (208 - 0.7 * age).toInt()
        // update in storage
        storage.store(KEY_CALCULATED_RESULT, calculatedResult)
        // update UI
        uiState.value?.let { model ->
            uiState.postValue(
                model.copy(
                    birthYear = year,
                    calculatedResult = if (calculatedResult > 0) calculatedResult else null,
                )
            )
        }
    }

    fun onInputMaxChanged(testValue: Int) {
        storage.store(KEY_TESTED_RESULT, testValue)
        uiState.value?.let { model ->
            uiState.postValue(
                model.copy(
                    testedMaxRate = testValue,
                )
            )
        }
    }

    sealed class UiEvent {
        data object Back : UiEvent()
    }

    companion object {
        const val KEY_CALCULATED_RESULT = "KEY_CALCULATED_RESULT"
        const val KEY_TESTED_RESULT = "KEY_TESTED_RESULT"
    }
}


package be.hcpl.android.sportapp.ui.view

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.ui.model.OverviewUiModel
import be.hcpl.android.sportapp.ui.model.StepItemUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel() : ViewModel() {

    // should use backing property here
    //private val _uiState = MutableLiveData<UiState>()
    //val uiState: LiveData<UiState>
    //    get() = _uiState

    private val _uiState = MutableStateFlow<UiState>(UiState(OverviewUiModel(emptyList())))
    val uiState = _uiState.asStateFlow()

    init {
        // TODO get from some pre config or settings instead
        // TODO plus also check progress made
        //_uiState.postValue(
            _uiState.update {
                UiState( // TODO copy from previous state instead
                    OverviewUiModel(
                        steps = listOf(
                            StepItemUiModel(1, "test", "description", false),
                            StepItemUiModel(2, "test", "description", false),
                            StepItemUiModel(3, "test", "description", false),
                        )
                    )
                )
            }
        //)
    }

    fun onSelect(){
        Log.d("TEST", "data update")
        _uiState.update {
            UiState( // TODO copy from previous state instead
                OverviewUiModel(
                    steps = listOf(
                        StepItemUiModel(1, "test", "description", false),
                        StepItemUiModel(2, "test", "description", true),
                        //StepItemUiModel(3, "test", "description", false),
                    )
                )
            )
        }
    }

}

data class UiState(
    val overview: OverviewUiModel,
)
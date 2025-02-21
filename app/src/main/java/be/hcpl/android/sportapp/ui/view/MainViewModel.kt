package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R

import android.content.Context
import android.widget.Toast
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

    init {
        _uiState.postValue(
            UiState(
                OverviewUiModel(
                    welcomeTitle = context.getString(R.string.welcome_title),
                    welcomeText = context.getString(R.string.welcome_text),
                    steps = listOf(
                        // TODO get these from domain, including completion
                        StepPosition.ABOUT.toUiModel(false),
                        StepPosition.MAX_HART_RATE.toUiModel(false),
                        StepPosition.VISUALISE_ZONES.toUiModel(false),
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
        // TODO handle step selection here
        Toast.makeText(context, "selected step $step", Toast.LENGTH_LONG).show()
    }
}

data class UiState(
    val overview: OverviewUiModel,
)
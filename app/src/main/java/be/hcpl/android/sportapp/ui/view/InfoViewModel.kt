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

class InfoViewModel(
    private val url: String?,
    private val context: Context,
) : ViewModel() {

    val uiState: MutableLiveData<UiState> = MutableLiveData<UiState>()
    val events: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()

    // contains basic HTML formatted info

    init {
        uiState.postValue(
            UiState(
                url = url ?: "https://www.google.be"
            )
        )
    }

    fun back() {
        events.postValue(UiEvent.Back)
    }

    data class UiState(
        val url: String,
    )

    sealed class UiEvent {
        data object Back : UiEvent()
    }
}


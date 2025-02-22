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
    private val context: Context,
) : ViewModel() {

    private val _uiState = MutableLiveData<UiState>()
    val uiState: LiveData<UiState>
        get() = _uiState

    // contains basic HTML formatted info

    init {
        _uiState.postValue(
            UiState(
                url = "https://www.google.be" // TODO change to param
            )
        )
    }

    data class UiState(
        val url: String,
    )
}


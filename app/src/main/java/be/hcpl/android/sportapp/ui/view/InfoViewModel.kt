package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.ui.Literals

class InfoViewModel(
    private val url: String?,
    private val title: String?,
    private val literals: Literals,
) : ViewModel() {

    val uiState: MutableLiveData<UiState> = MutableLiveData<UiState>()
    val events: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()

    // contains basic HTML formatted info

    init {
        uiState.postValue(
            UiState(
                title = title ?: literals.get(R.string.title_app),
                url = url ?: "https://www.google.be"
            )
        )
    }

    fun back() {
        events.postValue(UiEvent.Back)
    }

    data class UiState(
        val title: String,
        val url: String,
    )

    sealed class UiEvent {
        data object Back : UiEvent()
    }
}


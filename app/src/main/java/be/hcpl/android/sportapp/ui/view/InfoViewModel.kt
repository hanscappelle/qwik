package be.hcpl.android.sportapp.ui.view

import android.content.Context
import be.hcpl.android.sportapp.R
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class InfoViewModel(
    private val url: String?,
    private val title: String?,
    private val context: Context, // FIXME remove this
) : ViewModel() {

    val uiState: MutableLiveData<UiState> = MutableLiveData<UiState>()
    val events: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()

    // contains basic HTML formatted info

    init {
        uiState.postValue(
            UiState(
                title = title ?: context.getString(R.string.title_app),
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


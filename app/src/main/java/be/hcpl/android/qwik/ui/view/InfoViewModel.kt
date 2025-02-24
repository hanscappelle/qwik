package be.hcpl.android.qwik.ui.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.i18n.Literals
import be.hcpl.android.qwik.ui.model.WebViewUiModel

class InfoViewModel(
    private val title: String?,
    private val url: String?,
    private val assetId: Int?,
    literals: Literals,
) : ViewModel() {

    val uiState: MutableLiveData<UiState> = MutableLiveData<UiState>()
    val events: MutableLiveData<UiEvent> = MutableLiveData<UiEvent>()

    // contains basic HTML formatted info

    init {
        uiState.postValue(
            UiState(
                title = title ?: literals.get(R.string.title_app),
                webModel = WebViewUiModel(
                    assetId = assetId,
                    url = url ?: "https://www.google.be",
                )
            )
        )
    }

    fun back() {
        events.postValue(UiEvent.Back)
    }

    data class UiState(
        val title: String,
        val webModel: WebViewUiModel,
    )

    sealed class UiEvent {
        data object Back : UiEvent()
    }
}


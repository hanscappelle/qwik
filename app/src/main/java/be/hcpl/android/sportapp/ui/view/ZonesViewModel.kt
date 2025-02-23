package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.domain.model.StepPosition
import be.hcpl.android.sportapp.domain.storage.LocalStorage
import be.hcpl.android.sportapp.ui.i18n.Literals
import be.hcpl.android.sportapp.ui.model.OverviewUiModel
import be.hcpl.android.sportapp.ui.model.StepItemUiModel
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel

class ZonesViewModel(
    private val literals: Literals,
    private val storage: LocalStorage,
) : ViewModel() {

    val uiState: MutableLiveData<ZoneVisualUiModel> = MutableLiveData()

    init {
        uiState.postValue(
            ZoneVisualUiModel() // TODO
        )
    }

}
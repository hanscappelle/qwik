package be.hcpl.android.sportapp.ui.view

import android.content.res.Configuration
import be.hcpl.android.sportapp.R

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.sportapp.domain.storage.LocalStorage
import be.hcpl.android.sportapp.ui.i18n.Literals
import be.hcpl.android.sportapp.ui.model.TrainingUiModel
import be.hcpl.android.sportapp.ui.model.Zone
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel
import be.hcpl.android.sportapp.ui.theme.customColor1
import be.hcpl.android.sportapp.ui.theme.customColor2
import be.hcpl.android.sportapp.ui.theme.customColor3
import be.hcpl.android.sportapp.ui.theme.customColor4
import be.hcpl.android.sportapp.ui.theme.customColor9

class TrainingViewModel(
    literals: Literals,
    storage: LocalStorage,
) : ViewModel() {

    val uiState: MutableLiveData<TrainingUiModel> = MutableLiveData()

    init {
        val testedResult = storage.getInt(MaxRateViewModel.KEY_TESTED_RESULT)
        val calculatedResult = storage.getInt(MaxRateViewModel.KEY_CALCULATED_RESULT)
        uiState.postValue(
            TrainingUiModel(
                maxRate = testedResult.takeIf { it > 0 } ?: calculatedResult,
            )
        )
    }

}
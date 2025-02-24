package be.hcpl.android.qwik.ui.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.domain.repository.LocalProgramRepository
import be.hcpl.android.qwik.domain.storage.LocalStorage
import be.hcpl.android.qwik.ui.i18n.Literals
import be.hcpl.android.qwik.ui.model.ProgramUiModel
import be.hcpl.android.qwik.ui.model.TrainingUiModel
import be.hcpl.android.qwik.ui.model.Zone
import be.hcpl.android.qwik.ui.model.ZoneVisualUiModel
import be.hcpl.android.qwik.ui.theme.customColor1
import be.hcpl.android.qwik.ui.theme.customColor2
import be.hcpl.android.qwik.ui.theme.customColor3
import be.hcpl.android.qwik.ui.theme.customColor4
import be.hcpl.android.qwik.ui.theme.customColor9

class TrainingViewModel(
    literals: Literals,
    storage: LocalStorage,
    programRepo: LocalProgramRepository,
) : ViewModel() {

    val uiState: MutableLiveData<TrainingUiModel> = MutableLiveData()

    init {
        val testedResult = storage.getInt(MaxRateViewModel.KEY_TESTED_RESULT)
        val calculatedResult = storage.getInt(MaxRateViewModel.KEY_CALCULATED_RESULT)
        uiState.postValue(
            TrainingUiModel(
                zonesUiModel = ZoneVisualUiModel(
                    maxRate = testedResult.takeIf { it > 0 } ?: calculatedResult,
                    zones = listOf(
                        Zone(label = literals.get(R.string.label_zone_R), weight = 0.60f, color = customColor9),
                        Zone(label = literals.get(R.string.label_zone_D1), weight = 0.10f, color = customColor1),
                        Zone(label = literals.get(R.string.label_zone_D2), weight = 0.10f, color = customColor2),
                        Zone(label = literals.get(R.string.label_zone_D3), weight = 0.05f, color = customColor3),
                        Zone(label = literals.get(R.string.label_zone_D4), weight = 0.05f, color = customColor4),
                    )
                ),
                programs = programRepo.getAll().map { program -> ProgramUiModel(program) },
            )
        )
    }

}
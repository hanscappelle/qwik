package be.hcpl.android.sportapp.ui.model

import be.hcpl.android.sportapp.domain.model.StepPosition

data class StepItemUiModel(
    val step: StepPosition = StepPosition.NOT_SET,
    val label: String,
    val description: String,
    val completed: Boolean,
)
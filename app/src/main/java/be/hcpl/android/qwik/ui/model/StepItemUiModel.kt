package be.hcpl.android.qwik.ui.model

import be.hcpl.android.qwik.domain.model.StepPosition

data class StepItemUiModel(
    val step: StepPosition = StepPosition.NOT_SET,
    val label: String,
    val description: String,
    val completed: Boolean,
)
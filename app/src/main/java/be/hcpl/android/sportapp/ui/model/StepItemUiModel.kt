package be.hcpl.android.sportapp.ui.model

data class StepItemUiModel(
    val step: Int = -1,
    val label: String,
    val description: String,
    val completed: Boolean,
)
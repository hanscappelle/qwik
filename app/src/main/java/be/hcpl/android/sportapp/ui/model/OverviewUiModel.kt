package be.hcpl.android.sportapp.ui.model

data class OverviewUiModel(
    val welcomeTitle: String = "",
    val welcomeText: String = "",
    val steps: List<StepItemUiModel>,
)

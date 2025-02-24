package be.hcpl.android.qwik.ui.model

data class OverviewUiModel(
    val welcomeTitle: String = "",
    val welcomeText: String = "",
    val steps: List<StepItemUiModel>,
)

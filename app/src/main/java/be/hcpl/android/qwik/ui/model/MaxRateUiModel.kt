package be.hcpl.android.qwik.ui.model

data class MaxRateUiModel(
    val testVisible: Boolean = false,
    val calculateVisible: Boolean = false,
    val birthYear: Int? = null,
    val calculatedResult: Int? = null,
    val testedMaxRate: Int? = null,
)
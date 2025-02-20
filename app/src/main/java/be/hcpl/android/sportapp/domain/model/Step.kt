package be.hcpl.android.sportapp.domain.model

data class Step(
    val position: Int,
    val completed: Boolean = false,
    val description: String,
    val label: String,
)

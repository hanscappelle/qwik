package be.hcpl.android.sportapp.domain.model

import be.hcpl.android.sportapp.R

data class Step(
    val position: StepPosition,
    val completed: Boolean = false,
    val description: String,
    val label: String,
)

enum class StepPosition(
    val labelId: Int,
    val descriptionId: Int,
) {
    NOT_SET(0,0),
    ABOUT(R.string.about_label, R.string.about_description),
    MAX_HART_RATE(R.string.max_label, R.string.max_description),
    VISUALISE_ZONES(R.string.zones_label, R.string.zones_description),
}
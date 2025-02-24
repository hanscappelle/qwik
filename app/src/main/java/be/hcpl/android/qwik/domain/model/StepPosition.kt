package be.hcpl.android.qwik.domain.model

import be.hcpl.android.qwik.R

enum class StepPosition(
    val labelId: Int,
    val descriptionId: Int,
) {
    NOT_SET(0,0),
    HART_RATE_MONITORS(R.string.monitors_label, R.string.monitors_description),
    MAX_HART_RATE(R.string.max_label, R.string.max_description),
    VISUALISE_ZONES(R.string.zones_label, R.string.zones_description),
    TRAINING_PROGRAMS(R.string.programs_label, R.string.programs_description),
    ABOUT(R.string.about_label, R.string.about_description),
}
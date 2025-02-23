package be.hcpl.android.sportapp.ui.model

import androidx.compose.ui.graphics.Color

data class ZoneVisualUiModel(
    val maxRate: Int = 180,
    val zones: List<Zone> = emptyList(),
)

data class Zone(
    val label: String,
    val weight: Float,
    val color: Color,
)
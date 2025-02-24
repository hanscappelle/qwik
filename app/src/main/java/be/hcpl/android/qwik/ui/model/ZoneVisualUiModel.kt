package be.hcpl.android.qwik.ui.model

import androidx.compose.ui.graphics.Color

data class ZoneVisualUiModel(
    val optimizeLayout: Boolean = false,
    val maxRate: Int = 180,
    val zones: List<Zone> = emptyList(),
)

data class Zone(
    val label: String,
    val weight: Float,
    val color: Color,
)
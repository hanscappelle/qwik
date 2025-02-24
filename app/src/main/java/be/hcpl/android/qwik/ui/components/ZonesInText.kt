package be.hcpl.android.qwik.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.ui.model.ZoneVisualUiModel

@Composable
fun ZonesInText(
    model: ZoneVisualUiModel,
    modifier: Modifier = Modifier,
) {
    // TODO optimize, calculated twice now
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        var sum = 0f
        model.zones.forEachIndexed { index, zone ->
            sum = sum + (zone.weight * 100)
            val from = (sum / 100 * model.maxRate).toInt()
            if (index == model.zones.size - 1) {
                BodyLarge(text = "Zone ${zone.label}: $from - ${model.maxRate} bpm")
            } else if (index > 0) {
                val nextSum = sum + (model.zones[index + 1].weight * 100)
                val to = (nextSum / 100 * model.maxRate).toInt() - 1
                BodyLarge(text = "Zone ${zone.label}: $from - $to bpm")
            }
        }
    }
}
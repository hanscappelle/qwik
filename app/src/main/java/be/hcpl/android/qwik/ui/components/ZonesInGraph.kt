package be.hcpl.android.qwik.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.ui.model.ZoneVisualUiModel

@Composable
fun ZonesInGraph(
    model: ZoneVisualUiModel,
    maxHeight: Int,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)) {

        // zones bpm indications
        Box {
            Body(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = "${model.maxRate}|",
            )
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Body(
                    text = "",
                    modifier = Modifier.weight(1f / (model.zones.count())),
                )
                var sum = 0f
                model.zones.forEachIndexed { index, zone ->
                    sum = sum + (zone.weight * 100)
                    val from = (sum / 100 * model.maxRate).toInt()
                    if (index > 0)
                        Text(
                            text = "|$from",
                            modifier = Modifier.weight(1f / (model.zones.count())),
                        )
                }

            }
        }

        // zones visualisation with name
        Row(
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            var sum = 0f
            model.zones.forEachIndexed { index, zone ->
                sum = sum + (zone.weight * maxHeight)
                Box(
                    modifier = Modifier
                        .weight(1f / model.zones.count())
                        .height(sum.dp)
                        .background(color = zone.color)
                ) {
                    Body(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        text = zone.label
                    )
                }
            }
        }

    }
}
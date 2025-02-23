package be.hcpl.android.sportapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.R
import be.hcpl.android.sportapp.ui.model.Zone
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.customColor1
import be.hcpl.android.sportapp.ui.theme.customColor2
import be.hcpl.android.sportapp.ui.theme.customColor3
import be.hcpl.android.sportapp.ui.theme.customColor4
import be.hcpl.android.sportapp.ui.theme.customColor5
import be.hcpl.android.sportapp.ui.theme.customColor6
import be.hcpl.android.sportapp.ui.theme.customColor9

@Composable
fun ZoneVisualisationScreen(
    model: ZoneVisualUiModel,
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Body(
            text = stringResource(R.string.zones_intro)
        )

        Title(
            text = stringResource(R.string.zones_value, model.maxRate)
        )

        Body(
            text = stringResource(R.string.zones_visual_description)
        )

        // zones bpm indications
        Box() {
            Text(
                modifier = Modifier.align(Alignment.CenterEnd),
                text = "${model.maxRate}|",
            )
            Row(
                verticalAlignment = Alignment.Top,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
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
                sum = sum + (zone.weight * 100)
                val from = (sum / 100 * model.maxRate).toInt()
                Box(
                    modifier = Modifier
                        //.weight(zone.weight)
                        .weight(1f / model.zones.count())
                        //.height((zone.weight * 100).dp)
                        .height(sum.dp)
                        .background(color = zone.color)
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.BottomCenter),
                        //text = "${zone.label} ${if (index > 0) from else ""}"
                        text = zone.label
                    )
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ZoneVisualisationScreenPreview() {
    AppTheme {
        ZoneVisualisationScreen(
            ZoneVisualUiModel(
                maxRate = 196,
                zones = listOf(
                    Zone(label = "Herstel", weight = 0.60f, color = customColor9),
                    Zone(label = "D1", weight = 0.10f, color = customColor1),
                    Zone(label = "D2", weight = 0.10f, color = customColor2),
                    Zone(label = "D3", weight = 0.05f, color = customColor3),
                    Zone(label = "D4", weight = 0.05f, color = customColor4),
                    //Zone(label = "D5", weight = 0.10f, color = Color.Blue),
                )
            )
        )
    }
}
package be.hcpl.android.sportapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.R
import be.hcpl.android.sportapp.ui.components.Body
import be.hcpl.android.sportapp.ui.components.HeadLine
import be.hcpl.android.sportapp.ui.components.BodyLarge
import be.hcpl.android.sportapp.ui.components.TitleBold
import be.hcpl.android.sportapp.ui.components.ZonesInGraph
import be.hcpl.android.sportapp.ui.components.ZonesInText
import be.hcpl.android.sportapp.ui.model.Zone
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.customColor1
import be.hcpl.android.sportapp.ui.theme.customColor2
import be.hcpl.android.sportapp.ui.theme.customColor3
import be.hcpl.android.sportapp.ui.theme.customColor4
import be.hcpl.android.sportapp.ui.theme.customColor9

const val HEIGHT_LANDSCAPE = 180
const val HEIGHT_PORTRAIT = 100

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
        val maxHeight = if (!model.optimizeLayout) {
            // not optimized for graph layout
            // height is limited but also contains text
            BodyLarge(text = stringResource(R.string.zones_intro))
            HEIGHT_PORTRAIT
        } else {
            HEIGHT_LANDSCAPE
        }

        HeadLine(
            text = stringResource(R.string.zones_value, model.maxRate)
        )

        Card {
            Body(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                text = if (!model.optimizeLayout) stringResource(R.string.zones_landscape) else stringResource(R.string.zones_portrait)
            )
        }

        ZonesInGraph(model, maxHeight)

        // extra info
        if (!model.optimizeLayout) {
            // zones in text
            Spacer(modifier = Modifier.height(8.dp))
            Card(modifier = Modifier.fillMaxWidth()) {
                ZonesInText(model, Modifier.padding(16.dp))
            }

            // extra zone info
            Spacer(modifier = Modifier.height(8.dp))
            TitleBold(text = stringResource(R.string.zones_visual_description_header))
            Body(text = stringResource(R.string.zones_visual_description1))
            Body(text = stringResource(R.string.zones_visual_description2))
            Body(text = stringResource(R.string.zones_visual_description3))
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
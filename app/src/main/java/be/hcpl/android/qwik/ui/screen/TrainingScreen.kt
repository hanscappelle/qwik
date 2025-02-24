package be.hcpl.android.qwik.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.domain.model.Block
import be.hcpl.android.qwik.domain.model.Program
import be.hcpl.android.qwik.domain.model.RateZone
import be.hcpl.android.qwik.ui.components.Body
import be.hcpl.android.qwik.ui.components.BodyLarge
import be.hcpl.android.qwik.ui.components.HeadLine
import be.hcpl.android.qwik.ui.components.ProgramView
import be.hcpl.android.qwik.ui.components.ZonesInText
import be.hcpl.android.qwik.ui.model.ProgramUiModel
import be.hcpl.android.qwik.ui.model.TrainingUiModel
import be.hcpl.android.qwik.ui.model.ZoneVisualUiModel
import be.hcpl.android.qwik.ui.theme.AppTheme

@Composable
fun TrainingScreen(
    model: TrainingUiModel,
) {

    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        BodyLarge(text = stringResource(R.string.training_intro))
        HeadLine(text = stringResource(R.string.zones_value, model.zonesUiModel.maxRate))

        BodyLarge(text = stringResource(R.string.training_zones))

        // zones in text
        Card(modifier = Modifier.fillMaxWidth()) {
            ZonesInText(model.zonesUiModel, Modifier.padding(16.dp))
        }

        Body(text = stringResource(R.string.training_examples))

        model.programs.forEach { program ->
            ProgramView(program)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun TrainingScreenPreview() {
    AppTheme {
        TrainingScreen(
            model = TrainingUiModel(
                zonesUiModel = ZoneVisualUiModel(
                ),
                programs = listOf(
                    ProgramUiModel(
                        program = Program(
                            title = "Kracht-Training",
                            blocks = listOf(
                                Block(repeats = 1, "warm up", zone = RateZone.D0, durationMin = 10),
                                Block(4, "low cadans 80-90 rpm", zone = RateZone.D1, durationMin = 5),
                                Block(4, "zone", zone = RateZone.D1, durationMin = 5),
                                Block(1, "cool down", zone = RateZone.D0, durationMin = 10),
                            )
                        )
                    )
                )
            )
        )
    }
}
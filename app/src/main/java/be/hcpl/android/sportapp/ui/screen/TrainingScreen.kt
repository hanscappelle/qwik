package be.hcpl.android.sportapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.R
import be.hcpl.android.sportapp.ui.components.Body
import be.hcpl.android.sportapp.ui.components.BodyLarge
import be.hcpl.android.sportapp.ui.components.HeadLine
import be.hcpl.android.sportapp.ui.components.ZonesInText
import be.hcpl.android.sportapp.ui.model.TrainingUiModel
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme

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

        // TODO add some examples here....

        Body(text = "voorbeelden van trainings programma's zijn")
    }
}

@Preview(showBackground = true)
@Composable
fun TrainingScreenPreview() {
    AppTheme {
        TrainingScreen(
            model = TrainingUiModel(
                zonesUiModel = ZoneVisualUiModel(

                )
            )
        )
    }
}
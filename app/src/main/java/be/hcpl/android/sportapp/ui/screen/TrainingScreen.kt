package be.hcpl.android.sportapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.R
import be.hcpl.android.sportapp.ui.components.Body
import be.hcpl.android.sportapp.ui.components.BodyLarge
import be.hcpl.android.sportapp.ui.components.HeadLine
import be.hcpl.android.sportapp.ui.model.TrainingUiModel

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
        HeadLine(text = stringResource(R.string.zones_value, model.maxRate))

        BodyLarge(text = "De verschillende zones aangepast an uw gegevens; D1, D2, D3 en D4 zijn...")

        Body( text = "voorbeelden van trainings programma's zijn")
    }
}
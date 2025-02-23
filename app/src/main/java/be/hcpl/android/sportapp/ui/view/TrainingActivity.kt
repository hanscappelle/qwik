package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.model.TrainingUiModel
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.TrainingScreen
import be.hcpl.android.sportapp.ui.screen.ZoneVisualisationScreen
import org.koin.androidx.viewmodel.ext.android.viewModel

class TrainingActivity : ComponentActivity() {

    private val viewModel: TrainingViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState.observe(this, Observer<TrainingUiModel> { state -> onChangeObserved(state) })
    }

    private fun onChangeObserved(uiModel: TrainingUiModel) {
        setContent {
            AppScaffold(
                title = stringResource(R.string.title_training_programs),
                onBack = { finish() }) {
                TrainingScreen(uiModel)
            }
        }
    }

}
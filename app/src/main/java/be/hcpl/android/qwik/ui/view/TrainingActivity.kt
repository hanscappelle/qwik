package be.hcpl.android.qwik.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Observer
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.model.TrainingUiModel
import be.hcpl.android.qwik.ui.screen.AppScaffold
import be.hcpl.android.qwik.ui.screen.TrainingScreen
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
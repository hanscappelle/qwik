package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.i18n.Literals
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.MaxRateScreen
import be.hcpl.android.sportapp.ui.model.MaxRateUiModel
import be.hcpl.android.sportapp.ui.view.MaxRateViewModel.UiEvent
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MaxRateActivity : ComponentActivity() {

    private val viewModel: MaxRateViewModel by viewModel()
    private val literals: Literals by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState.observe(this, Observer<MaxRateUiModel> { state -> onChangeObserved(state) })
        viewModel.events.observe(this, Observer<UiEvent> { event -> onEvent(event) })
    }

    private fun onEvent(event: UiEvent) {
        when (event) {
            UiEvent.Back -> finish()
        }
    }

    private fun onChangeObserved(uiModel: MaxRateUiModel) {
        setContent {
            AppScaffold(
                title = literals.get(R.string.title_max_rate),
                onBack = { viewModel.back() },
            ) {
                MaxRateScreen(
                    model = uiModel,
                    onSelectTest = { viewModel.onSelectTest() },
                    onSelectCalculate = { viewModel.onSelectCalculate() },
                    onMaxChanged = { input -> viewModel.onInputMaxChanged(input) },
                    onYearChanged = { input -> viewModel.onInputChanged(input) },
                )
            }

        }
    }

}
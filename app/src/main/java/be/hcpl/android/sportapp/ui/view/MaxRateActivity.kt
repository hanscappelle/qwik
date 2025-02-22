package be.hcpl.android.sportapp.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.MaxRateScreen
import be.hcpl.android.sportapp.ui.view.MaxRateViewModel.UiEvent
import be.hcpl.android.sportapp.ui.view.MaxRateViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MaxRateActivity : ComponentActivity() {

    private val viewModel: MaxRateViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState.observe(this, Observer<UiState> { state -> onChangeObserved(state) })
        viewModel.events.observe(this, Observer<UiEvent> { event -> onEvent(event) })
    }

    private fun onEvent(event: UiEvent) {
        when (event) {
            UiEvent.Back -> finish()
        }
    }

    private fun onChangeObserved(uiState: UiState) {
        setContent {
            AppScaffold(
                title = "Omslagpunt bepalen",
                onBack = { viewModel.back() },
            ) {
                MaxRateScreen(
                    model = uiState.uiModel,
                    onSelectTest = { viewModel.onSelectTest() },
                    onSelectCalculate = { viewModel.onSelectCalculate() },
                    onAgeChanged = { input -> viewModel.onInputChanged(input)}
                )
            }

        }
    }

}
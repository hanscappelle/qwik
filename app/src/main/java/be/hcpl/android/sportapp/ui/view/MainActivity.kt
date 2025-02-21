package be.hcpl.android.sportapp.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.theme.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    // TODO app icon needed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val stateObserver = Observer<UiState> { state -> onChangeObserved(state) }
        viewModel.uiState.observe(this, stateObserver)
    }

    private fun onChangeObserved(uiState: UiState) {
        setContent {
            AppTheme {
                StepOverviewScreen(uiState.overview, onSelect = { viewModel.onSelect() })
            }

        }
    }
}
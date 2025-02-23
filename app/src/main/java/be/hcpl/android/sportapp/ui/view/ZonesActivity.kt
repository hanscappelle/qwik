package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.screen.ZoneVisualisationScreen
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent.InfoView
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZonesActivity : ComponentActivity() {

    private val viewModel: ZonesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun onChangeObserved(uiModel: ZoneVisualUiModel) {
        setContent {
            AppScaffold(onBack = { finish() }) {
                ZoneVisualisationScreen(uiModel)
            }
        }
    }

}
package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import be.hcpl.android.sportapp.ui.model.ZoneVisualUiModel
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.screen.ZoneVisualisationScreen
import be.hcpl.android.sportapp.ui.view.InfoActivity.Companion.KEY_URL
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent.InfoView
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class ZonesActivity : ComponentActivity() {

    private val viewModel: ZonesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.uiState.observe(this, Observer<ZoneVisualUiModel> { state -> onChangeObserved(state) })
    }

    override fun onResume() {
        super.onResume()
        viewModel.updateOptimalisation(resources.configuration.orientation)
    }

    private fun onChangeObserved(uiModel: ZoneVisualUiModel) {
        setContent {
            AppScaffold(
                title = stringResource(R.string.title_zones),
                onBack = { finish() }) {
                ZoneVisualisationScreen(uiModel,
                onUrlClicked = { url -> navigateToUrl(url) }
                )
            }
        }
    }

    private fun navigateToUrl(url: String) {
        // TODO move to VM
        startActivity(Intent(this, InfoActivity::class.java).apply {
            putExtra(KEY_URL, url)
        })
    }

}
package be.hcpl.android.qwik.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import be.hcpl.android.qwik.ui.screen.AppScaffold
import be.hcpl.android.qwik.ui.screen.StepOverviewScreen
import be.hcpl.android.qwik.ui.view.MainViewModel.UiEvent
import be.hcpl.android.qwik.ui.view.MainViewModel.UiEvent.InfoView
import be.hcpl.android.qwik.ui.view.MainViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        viewModel.uiState.observe(this, Observer<UiState> { state -> onChangeObserved(state) })
        viewModel.events.observe(this, Observer<UiEvent> { event -> onEvent(event) })
    }

    override fun onResume() {
        super.onResume()
        viewModel.refresh()
    }

    private fun onChangeObserved(uiState: UiState) {
        setContent {
            AppScaffold {
                StepOverviewScreen(uiState.overview, onSelect = { id -> viewModel.onSelect(id) })
            }
        }
    }

    private fun onEvent(event: UiEvent) {
        when (event) {
            is InfoView -> startActivity(Intent(this, HardwareInfoActivity::class.java))
            UiEvent.AboutApp -> startActivity(Intent(this, AboutAppActivity::class.java))
            UiEvent.MaxRate -> startActivity(Intent(this, MaxRateActivity::class.java))
            UiEvent.Zones -> startActivity(Intent(this, ZonesActivity::class.java))
            UiEvent.Training -> startActivity(Intent(this, TrainingActivity::class.java))
        }
    }
}
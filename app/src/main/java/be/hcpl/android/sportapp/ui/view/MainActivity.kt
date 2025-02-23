package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent.InfoView
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    // TODO app icon needed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        viewModel.uiState.observe(this, Observer<UiState> { state -> onChangeObserved(state) })
        viewModel.events.observe(this, Observer<UiEvent> { event -> onEvent(event) })
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
            is InfoView -> {
                startActivity(Intent(this, InfoActivity::class.java).apply {
                    putExtra(
                        InfoActivity.KEY_URL,
                        "https://www.asadventure.com/nl/expertise-tips/Activewear/hoe-kies-je-de-beste-hartslagmeter.html"
                    )
                    putExtra(
                        InfoActivity.KEY_TITLE,
                        getString(R.string.monitors_label)
                    )
                    putExtra(
                        InfoActivity.KEY_ASSET_ID,
                        R.raw.heart_rate_monitors,
                    )
                })
            }

            UiEvent.AboutApp -> {
                startActivity(Intent(this, InfoActivity::class.java).apply {
                    putExtra(
                        InfoActivity.KEY_URL,
                        "https://www.dropbox.com/scl/fi/n3euk925u33viwwy60e4o/privacy-policy.html?rlkey=e52fsan1pmgu7lyt3uvybqyws&st=w8f8utht",
                    )
                    putExtra(
                        InfoActivity.KEY_TITLE,
                        getString(R.string.about_label)
                    )
                    putExtra(
                        InfoActivity.KEY_ASSET_ID,
                        R.raw.about_app,
                    )
                })
            }

            UiEvent.MaxRate -> startActivity(Intent(this, MaxRateActivity::class.java))
            UiEvent.Zones -> startActivity(Intent(this, ZonesActivity::class.java))
            UiEvent.Training -> startActivity(Intent(this, TrainingActivity::class.java))
        }
    }
}
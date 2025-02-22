package be.hcpl.android.sportapp.ui.view

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.ui.Modifier
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.InfoViewScreen
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiEvent.InfoView
import be.hcpl.android.sportapp.ui.view.MainViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel

@OptIn(ExperimentalMaterial3Api::class)
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
                val intent = Intent(this, InfoActivity::class.java).apply {
                    putExtra(
                        InfoActivity.KEY_URL,
                        "https://www.asadventure.com/nl/expertise-tips/Activewear/hoe-kies-je-de-beste-hartslagmeter.html"
                    )
                }
                startActivity(intent)
            }
        }
    }
}
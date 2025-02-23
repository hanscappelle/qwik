package be.hcpl.android.sportapp.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.InfoViewScreen
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.view.InfoViewModel.UiEvent
import be.hcpl.android.sportapp.ui.view.InfoViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.lang.System.exit

class InfoActivity : ComponentActivity() {

    private val viewModel: InfoViewModel by viewModel {
        parametersOf(
            intent.getStringExtra(KEY_TITLE),
            intent.getStringExtra(KEY_URL),
            intent.getIntExtra(KEY_ASSET_ID, 0),
        )
    }

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
                title = uiState.title,
                onBack = { viewModel.back() },
            ) {
                InfoViewScreen(uiState.webModel)
            }

        }
    }

    companion object {
        const val KEY_TITLE = "KEY_TITLE"
        const val KEY_URL = "KEY_URL"
        const val KEY_ASSET_ID = "KEY_ASSET_ID"
    }
}
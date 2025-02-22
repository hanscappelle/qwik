package be.hcpl.android.sportapp.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.InfoViewScreen
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.view.InfoViewModel.UiState
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class InfoActivity : ComponentActivity() {

    private val viewModel: InfoViewModel by viewModel {
        parametersOf(intent.getStringExtra(KEY_URL))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val stateObserver = Observer<UiState> { state -> onChangeObserved(state) }
        viewModel.uiState.observe(this, stateObserver)
    }

    private fun onChangeObserved(uiState: UiState) {
        setContent {
            AppScaffold {
                InfoViewScreen(uiState.url)
            }

        }
    }

    companion object {
        const val KEY_URL = "KEY_URL"
    }
}
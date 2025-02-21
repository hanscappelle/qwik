package be.hcpl.android.sportapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.screen.LiveDataStepOverviewScreen
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.theme.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class LiveDataActivity : ComponentActivity() {

    // alternative approach to the StateFlow version using LiveData and setting content again on observed changes

    private val viewModel: LiveDataViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Create the observer which updates the UI.
        val stateObserver = Observer<UiState> { state ->
            // Update the UI
            onChangeObserved(state)
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        viewModel.uiState.observe(this, stateObserver)
    }

    private fun onChangeObserved(uiState: UiState) {
        Log.d("TEST", "change observed $uiState")
        setContent {
            AppTheme {
                LiveDataStepOverviewScreen(uiState.overview, onSelect = {viewModel.onSelect()})
            }

        }
    }

}
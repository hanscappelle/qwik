package be.hcpl.android.sportapp.ui.view

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.Observer
import be.hcpl.android.sportapp.ui.model.OverviewUiModel
import be.hcpl.android.sportapp.ui.screen.StepOverviewScreen
import be.hcpl.android.sportapp.ui.theme.AppTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModel()

    // TODO app icon needed

    var uiModel: OverviewUiModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //var uiModel by remember { mutableStateOf<OverviewUiModel>(OverviewUiModel(emptyList())) }
            //var uiModel = remember { mutableStateOf(OverviewUiModel(emptyList())) }
            AppTheme {
                //StepOverviewScreen(uiModel)
                StepOverviewScreen(viewModel)
            }

        }

        // Create the observer which updates the UI.
        //val stateObserver = Observer<UiState> { state ->
        //    // Update the UI, in this case, a TextView.
        //    uiModel = state.overview
        //    Log.d("TEST", "new data received ${state.overview}")
        //}

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        //viewModel.uiState.observe(this, stateObserver)
        //viewModel.uiState.
    }
}
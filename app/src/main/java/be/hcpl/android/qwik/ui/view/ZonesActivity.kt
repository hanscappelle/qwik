package be.hcpl.android.qwik.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.Observer
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.model.ZoneVisualUiModel
import be.hcpl.android.qwik.ui.screen.AppScaffold
import be.hcpl.android.qwik.ui.screen.ZoneVisualisationScreen
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

}
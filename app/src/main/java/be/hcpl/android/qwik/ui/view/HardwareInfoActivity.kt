package be.hcpl.android.qwik.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.i18n.Literals
import be.hcpl.android.qwik.ui.screen.AppScaffold
import be.hcpl.android.qwik.ui.screen.HardwareInfoScreen
import org.koin.android.ext.android.inject

class HardwareInfoActivity : ComponentActivity() {

    private val literals: Literals by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScaffold(
                title = literals.get(R.string.title_hardware_info),
                onBack = { finish() },
            ) {
                HardwareInfoScreen(
                    onUrlClicked = { url -> navigateToUrl(url) }
                )
            }

        }
    }

}
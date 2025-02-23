package be.hcpl.android.sportapp.ui.view

import be.hcpl.android.sportapp.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import be.hcpl.android.sportapp.ui.i18n.Literals
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.HardwareInfoScreen
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
                HardwareInfoScreen()
            }

        }
    }

}
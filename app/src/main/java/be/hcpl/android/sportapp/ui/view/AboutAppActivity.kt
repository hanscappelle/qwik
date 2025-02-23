package be.hcpl.android.sportapp.ui.view

import android.content.Intent
import be.hcpl.android.sportapp.R
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import be.hcpl.android.sportapp.domain.storage.LocalStorage
import be.hcpl.android.sportapp.ui.i18n.Literals
import be.hcpl.android.sportapp.ui.screen.AboutAppScreen
import be.hcpl.android.sportapp.ui.screen.AppScaffold
import be.hcpl.android.sportapp.ui.screen.HardwareInfoScreen
import be.hcpl.android.sportapp.ui.view.InfoActivity.Companion.KEY_URL
import org.koin.android.ext.android.inject

class AboutAppActivity : ComponentActivity() {

    private val literals: Literals by inject()
    private val storage: LocalStorage by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppScaffold(
                title = literals.get(R.string.about_label),
                onBack = { finish() },
            ) {
                AboutAppScreen(
                    onUrlClicked = { url -> navigateToUrl(url) },
                    onErase = { storage.clearAll() }
                )
            }

        }
    }

    private fun navigateToUrl(url: String) {
        startActivity(Intent(this, InfoActivity::class.java).apply {
            putExtra(KEY_URL, url)
        })
    }

}
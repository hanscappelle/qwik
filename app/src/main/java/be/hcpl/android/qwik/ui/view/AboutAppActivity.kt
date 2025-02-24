package be.hcpl.android.qwik.ui.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.domain.storage.LocalStorage
import be.hcpl.android.qwik.ui.i18n.Literals
import be.hcpl.android.qwik.ui.screen.AboutAppScreen
import be.hcpl.android.qwik.ui.screen.AppScaffold
import be.hcpl.android.qwik.ui.view.InfoActivity.Companion.KEY_URL
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


}

fun Activity.navigateToUrl(url: String) {
    startActivity(Intent(this, InfoActivity::class.java).apply {
        putExtra(KEY_URL, url)
    })
}

package be.hcpl.android.sportapp.ui.screen

import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView


@Composable
fun InfoViewScreen(url: String) {
    WebView(url)
}

@Composable
fun WebView(url: String) {

    // TODO add a loading indication

    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.javaScriptEnabled = true
        }
    }, update = {
        it.loadUrl(url)
    })
}
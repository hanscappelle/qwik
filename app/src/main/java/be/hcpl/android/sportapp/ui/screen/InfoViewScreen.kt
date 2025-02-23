package be.hcpl.android.sportapp.ui.screen

import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidView
import android.webkit.WebView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import be.hcpl.android.sportapp.ui.model.WebViewUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme

@Composable
fun InfoViewScreen(model: WebViewUiModel = WebViewUiModel("http://www.google.be")) {
    WebView(model)
}

@Composable
fun WebView(model: WebViewUiModel) {

    // TODO add a loading indication
    val context = LocalContext.current

    // Adding a WebView inside AndroidView
    // with layout as full screen
    AndroidView(factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            settings.apply {
                javaScriptEnabled = true
                allowFileAccess = true
            }

        }
    }, update = {
        model.assetId?.takeIf { it != 0 }?.let { id ->
            context.resources.openRawResource(id).bufferedReader().use { reader ->
                it.loadData(reader.readText(), "text/html", "utf-8")
            }
        } ?: it.loadUrl(model.url)
    })
}

@Preview(showBackground = true)
@Composable
fun InfoViewPreview1() {
    AppTheme {
        InfoViewScreen()
    }
}
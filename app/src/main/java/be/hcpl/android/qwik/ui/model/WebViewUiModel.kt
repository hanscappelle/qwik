package be.hcpl.android.qwik.ui.model

import androidx.annotation.RawRes

data class WebViewUiModel(
    val url: String,
    @RawRes val assetId: Int? = null,
)
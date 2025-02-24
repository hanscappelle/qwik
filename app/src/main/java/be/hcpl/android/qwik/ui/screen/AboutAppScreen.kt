package be.hcpl.android.qwik.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.components.Body
import be.hcpl.android.qwik.ui.components.HeadLine
import be.hcpl.android.qwik.ui.components.TitleBold
import be.hcpl.android.qwik.ui.theme.AppTheme

@Composable
fun AboutAppScreen(
    onUrlClicked: (String) -> Unit,
    onErase: () -> Unit,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HeadLine(stringResource(R.string.about_header))

        Body(text = stringResource(R.string.about_description1))
        Body(text = stringResource(R.string.about_description2))

        TitleBold(text = stringResource(R.string.about_privacy_header))
        Body(text = stringResource(R.string.about_privacy_description1))
        Body(text = stringResource(R.string.about_privacy_description2))
        Button(
            onClick = { onErase() }
        ) {
            Text(text = stringResource(R.string.about_privacy_erase))
        }

        TitleBold(text = stringResource(R.string.about_reference_header))
        Body(text = stringResource(R.string.about_reference_description1), onUrlClicked = onUrlClicked)
        Body(text = stringResource(R.string.about_reference_description2), onUrlClicked = onUrlClicked)
        Body(text = stringResource(R.string.about_reference_description3), onUrlClicked = onUrlClicked)
    }
}

@Composable
@Preview(showBackground = true)
fun AboutAppScreenPreview() {
    AppTheme {
        AboutAppScreen({}, {})
    }
}
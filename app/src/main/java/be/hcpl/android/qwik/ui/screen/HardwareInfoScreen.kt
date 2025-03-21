package be.hcpl.android.qwik.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.components.Body
import be.hcpl.android.qwik.ui.components.HeadLine
import be.hcpl.android.qwik.ui.components.InfoCard
import be.hcpl.android.qwik.ui.components.TitleBold
import be.hcpl.android.qwik.ui.theme.AppTheme

@Composable
fun HardwareInfoScreen(
    onUrlClicked: (String) -> Unit,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        HeadLine(stringResource(R.string.hardware_header1))

        TitleBold(text = stringResource(R.string.hardware_title1))
        Body(text = stringResource(R.string.hardware_description1))

        TitleBold(text = stringResource(R.string.hardware_title2))
        Body(text = stringResource(R.string.hardware_description2))

        TitleBold(text = stringResource(R.string.hardware_title3))
        Body(text = stringResource(R.string.hardware_description3))

        InfoCard(
            title = stringResource(R.string.hardware_title4),
            text = stringResource(R.string.hardware_description4),
            onUrlClicked = onUrlClicked,
        )

    }
}

@Composable
@Preview(showBackground = true)
fun HardwareInfoScreenPreview() {
    AppTheme {
        HardwareInfoScreen({})
    }
}
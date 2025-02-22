package be.hcpl.android.sportapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import be.hcpl.android.sportapp.R
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.AppTypography
import be.hcpl.android.sportapp.ui.theme.primaryDark
import be.hcpl.android.sportapp.ui.theme.primaryLight

data class MaxRateUiModel(
    val testVisible: Boolean = false,
    val calculateVisible: Boolean = false,
    val birthYear: Int? = null,
    val calculatedResult: Int? = null,
)

@Composable
fun MaxRateScreen(
    model: MaxRateUiModel,
    onSelectTest: () -> Unit = {},
    onSelectCalculate: () -> Unit = {},
    onAgeChanged: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Title(
            text = stringResource(R.string.max_rate_intro)
        )
        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onSelectTest() },
        ) {
            Body(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.max_rate_option1),
            )
        }

        if (model.testVisible)
            MaxRateTestScreen()

        Card(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onSelectCalculate() },
        ) {
            Body(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.max_rate_option2),
            )
        }

        if (model.calculateVisible)
            MaxRateCalculateScreen(
                model = model,
                onAgeChanged = { value -> onAgeChanged(value) }
            )
    }

}

@Composable
fun MaxRateTestScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        //Title(text = stringResource(R.string.max_rate_option1))
        Body(text = stringResource(R.string.max_rate_option1_description1))
        Body(text = stringResource(R.string.max_rate_option1_description2))
        Body(text = stringResource(R.string.max_rate_option1_description3))
        Body(text = stringResource(R.string.max_rate_option1_description4))
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Title(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.max_rate_extra_title)
            )
            Body(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.max_rate_option1_extra)
            )
        }
    }
}

@Composable
fun MaxRateCalculateScreen(
    model: MaxRateUiModel,
    modifier: Modifier = Modifier,
    onAgeChanged: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        //Title(text = stringResource(R.string.max_rate_option2))
        Body(text = stringResource(R.string.max_rate_option2_description1))
        TextField(
            value = model.birthYear?.toString() ?: "",
            onValueChange = { year -> onAgeChanged(year) },
            label = {
                Text(text = stringResource(R.string.label_age))
            }
        )
        Body(
            text = stringResource(R.string.max_rate_option2_description_result)
        )
        Value(
            text = "${model.calculatedResult ?: ""}"
        )
        Card(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Title(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.max_rate_extra_title)
            )
            Body(
                modifier = Modifier.padding(16.dp),
                text = stringResource(R.string.max_rate_option2_extra)
            )
        }
    }
}

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTypography.titleLarge
    )
}

@Composable
fun Body(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTypography.bodyLarge
    )
}

@Composable
fun Value(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTypography.headlineLarge,
        color = primaryLight,
    )
}


@Preview(showBackground = true)
@Composable
fun MaxRateScreenPreview() {
    AppTheme {
        Value("test")
        MaxRateScreen(MaxRateUiModel(true, true))

    }
}
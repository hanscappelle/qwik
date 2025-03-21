package be.hcpl.android.qwik.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.components.Body
import be.hcpl.android.qwik.ui.components.InfoCard
import be.hcpl.android.qwik.ui.components.NumericInput
import be.hcpl.android.qwik.ui.components.Title
import be.hcpl.android.qwik.ui.components.Value
import be.hcpl.android.qwik.ui.model.MaxRateUiModel
import be.hcpl.android.qwik.ui.theme.AppTheme
import be.hcpl.android.qwik.ui.theme.primaryLight

@Composable
fun MaxRateScreen(
    model: MaxRateUiModel,
    onSelectTest: () -> Unit = {},
    onSelectCalculate: () -> Unit = {},
    onMaxChanged: (Int) -> Unit = {},
    onYearChanged: (Int) -> Unit = {},
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
        Option(
            text = "${stringResource(R.string.max_rate_option2)} (${model.calculatedResult ?: "-"})",
            onSelect = onSelectCalculate,
            isVisible = model.calculateVisible,
        )
        if (model.calculateVisible)
            MaxRateCalculateScreen(
                model = model,
                onYearChanged = { value -> onYearChanged(value) },
            )

        Option(
            text = "${stringResource(R.string.max_rate_option1)} (${model.testedMaxRate ?: "-"})",
            onSelect = onSelectTest,
            isVisible = model.testVisible,
        )
        if (model.testVisible)
            MaxRateTestScreen(
                model,
                onMaxChanged = { value -> onMaxChanged(value) },
            )

    }

}

@Composable
fun Option(
    text: String,
    onSelect: () -> Unit,
    isVisible: Boolean = false,
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = { onSelect() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Body(
                modifier = Modifier
                    .padding(16.dp)
                    .weight(1f),
                text = text,
            )
            Icon(
                if (isVisible) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                tint = primaryLight,
                contentDescription = if (isVisible) stringResource(R.string.description_collapse) else stringResource(R.string.description_expand),
                modifier = Modifier
                    .padding(8.dp)
                    .size(24.dp)
            )
        }
    }
}

@Composable
fun MaxRateTestScreen(
    model: MaxRateUiModel,
    onMaxChanged: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        //Title(text = stringResource(R.string.max_rate_option1))
        Body(text = stringResource(R.string.max_rate_option1_description1))
        Body(text = stringResource(R.string.max_rate_option1_description2))
        Body(text = stringResource(R.string.max_rate_option1_description3))
        Body(text = stringResource(R.string.max_rate_option1_description4))
        NumericInput(
            value = model.testedMaxRate,
            onValueChange = { year -> onMaxChanged(year) },
            label = stringResource(R.string.label_tested_max_rate)
        )
        InfoCard(
            title = stringResource(R.string.max_rate_extra_title),
            text = stringResource(R.string.max_rate_option1_extra),
        )
    }
}

@Composable
fun MaxRateCalculateScreen(
    model: MaxRateUiModel,
    onYearChanged: (Int) -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .then(modifier),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        //Title(text = stringResource(R.string.max_rate_option2))
        Body(text = stringResource(R.string.max_rate_option2_description1))
        NumericInput(
            value = model.birthYear,
            onValueChange = { year -> onYearChanged(year) },
            label = stringResource(R.string.label_birth_year)
        )
        Body(
            text = stringResource(R.string.max_rate_option2_description_result)
        )
        Value(
            text = "${model.calculatedResult ?: ""}"
        )
        InfoCard(
            title = stringResource(R.string.max_rate_extra_title),
            text = stringResource(R.string.max_rate_option2_extra),
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MaxRateScreenPreview() {
    AppTheme {
        MaxRateScreen(MaxRateUiModel(true, true))
    }
}
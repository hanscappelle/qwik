package be.hcpl.android.sportapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.R
import be.hcpl.android.sportapp.ui.theme.AppTypography
import be.hcpl.android.sportapp.ui.theme.primaryLight

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTypography.titleLarge,
        fontWeight = fontWeight
    )
}

@Composable
fun TitleBold(
    text: String,
    modifier: Modifier = Modifier,
) {
    Title(
        modifier = modifier,
        text = text,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun HeadLine(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        modifier = modifier,
        text = text,
        style = AppTypography.headlineLarge
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
fun BodyLarge(
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

@Composable
fun NumericInput(
    value: Int? = null,
    onValueChange: (Int) -> Unit,
    label: String? = null,
) {
    TextField(
        value = value?.toString().orEmpty(),
        onValueChange = { value -> onValueChange(value.toIntOrNull() ?: 0) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = {
            label?.let { Text(text = it) }
        }
    )
}

@Composable
fun InfoCard(
    title: String? = null,
    text: String,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {

        Title(
            modifier = Modifier.padding(16.dp),
            text = title ?: stringResource(R.string.max_rate_extra_title)
        )
        Body(
            modifier = Modifier.padding(16.dp),
            text = text,
        )
    }
}
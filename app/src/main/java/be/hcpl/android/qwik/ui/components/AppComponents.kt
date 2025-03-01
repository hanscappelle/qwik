@file:OptIn(ExperimentalTextApi::class)

package be.hcpl.android.qwik.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.R
import be.hcpl.android.qwik.ui.theme.AppTheme
import be.hcpl.android.qwik.ui.theme.AppTypography
import be.hcpl.android.qwik.ui.theme.primaryLight
import uz.kjuraev.linkify.LinkifyContent
import uz.kjuraev.linkify.LinkifyText

@Composable
fun Title(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = AppTypography.titleLarge,
    fontWeight: FontWeight = FontWeight.Normal,
) {
    Text(
        modifier = modifier,
        text = text,
        style = style,
        fontWeight = fontWeight
    )
}

@Composable
fun TitleBold(
    text: String,
    style: TextStyle = AppTypography.titleLarge,
    modifier: Modifier = Modifier,
) {
    Title(
        modifier = modifier,
        text = text,
        style = style,
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
    onUrlClicked: ((String) -> Unit)? = null,
) {
    if (onUrlClicked != null ){
        // linkify is expected here
        LinkifyText(
            modifier = modifier,
            content = LinkifyContent(
                originalText = text,
                spanStyle = SpanStyle(
                    color = primaryLight,
                    textDecoration = TextDecoration.Underline,
                ),
            ),
            style = AppTypography.bodyLarge.copy(color = LocalContentColor.current),
            onUrlClicked = onUrlClicked,
        )
    } else {
        Text(
            modifier = modifier,
            text = text,
            style = AppTypography.bodyLarge
        )
    }
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
    onUrlClicked: ((String) -> Unit) = {},
) {
    // fix for ClickableText text color in dark mode
    val color = LocalContentColor.current

    Card(
        modifier = modifier.fillMaxWidth()
    ) {

        Title(
            modifier = Modifier.padding(16.dp),
            text = title ?: stringResource(R.string.max_rate_extra_title)
        )
        LinkifyText(
            modifier = Modifier.padding(start = 16.dp, top = 0.dp, end = 16.dp, bottom = 16.dp),
            content = LinkifyContent(
                originalText = text,
                spanStyle = SpanStyle(
                    color = primaryLight,
                    textDecoration = TextDecoration.Underline,
                ),
            ),
            style = AppTypography.bodyLarge.copy(color = color),
            onUrlClicked = onUrlClicked,
        )

    }
}

@Preview(showBackground = true)
@Composable
fun InfoCardPreview() {
    AppTheme {
        InfoCard(text = "example text")
    }
}
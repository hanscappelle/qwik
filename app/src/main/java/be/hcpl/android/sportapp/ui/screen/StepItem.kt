package be.hcpl.android.sportapp.ui.screen

import be.hcpl.android.sportapp.R

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.ui.model.StepItemUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.AppTypography
import be.hcpl.android.sportapp.ui.theme.customColor1Dark
import be.hcpl.android.sportapp.ui.theme.customColor1Light
import be.hcpl.android.sportapp.ui.theme.customColor3Light
import be.hcpl.android.sportapp.ui.theme.primaryLight
import be.hcpl.android.sportapp.ui.theme.tertiaryLight

@Composable
fun StepItem(
    model: StepItemUiModel,
    onSelect: () -> Unit = {},
    modifier: Modifier = Modifier,
) {
    Card(onClick = { onSelect() }) {
        Box {
            CompletionIndicator(
                model.completed,
                Modifier
                    .align(Alignment.BottomEnd)
                    .size(120.dp)
                    .alpha(0.30f)
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    style = AppTypography.titleLarge,
                    text = model.label,
                    color = customColor1Light,
                )
                Text(
                    style = AppTypography.bodyLarge,
                    text = model.description,
                )
            }
        }
    }
}

@Composable
fun CompletionIndicator(completed: Boolean, modifier: Modifier) {
    if (completed)
        Icon(
            Icons.Outlined.Check,
            modifier = modifier,
            tint = customColor1Light,
            contentDescription = stringResource(id = R.string.content_description_checked),
        )
}

@Composable
@Preview("not completed", showBackground = true)
fun StepItemPreview1() {
    AppTheme {
        StepItem(
            model = StepItemUiModel(
                label = "Bepaal je maximale harstlag",
                description = "Om gezond te sporten is het van cruciaal belang je harstlag te volgen. Hier bepalen we eerst je maximale harstlag.",
                completed = false,
            )
        )
    }
}

@Composable
@Preview("completed", showBackground = true)
fun StepItemPreview2() {
    AppTheme {
        StepItem(
            model = StepItemUiModel(
                label = "Bepaal je maximale harstlag",
                description = "Om gezond te sporten is het van cruciaal belang je harstlag te volgen. Hier bepalen we eerst je maximale harstlag.",
                completed = true,
            )
        )
    }
}

package be.hcpl.android.sportapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.ui.model.OverviewUiModel
import be.hcpl.android.sportapp.ui.model.StepItemUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.AppTypography

// TODO literals

@Composable
fun StepOverviewScreen(
    model: OverviewUiModel?,
    onSelect: () -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        item {
            Text(
                style = AppTypography.headlineLarge,
                text = "Welkom sporter",
            )
            Text(
                style = AppTypography.bodyLarge,
                text = "Volg onderstaande stappenplan om gezond en verantwoord te sporten op basis van je hartslag."
            )
        }
        model?.steps?.forEach {
            item {
                StepItem(model = it, onSelect = { onSelect.invoke() })
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun StepOverviewScreenPreview() {
    AppTheme {
        StepOverviewScreen(
            model = OverviewUiModel(
                steps = listOf(
                    StepItemUiModel(1, "step1", "description", true),
                    StepItemUiModel(2, "step2", "description", false),
                    StepItemUiModel(3, "step3", "description", false),
                ),
            ),
            onSelect = {},
        )
    }
}
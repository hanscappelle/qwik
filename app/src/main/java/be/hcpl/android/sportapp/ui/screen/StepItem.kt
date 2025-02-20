package be.hcpl.android.sportapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import be.hcpl.android.sportapp.ui.model.StepItemUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.AppTypography

@Composable
fun StepItem(
    model: StepItemUiModel,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Text(
            style = AppTypography.labelLarge,
            text = model.label,
        )
        Text(
            style = AppTypography.labelMedium,
            text = model.description,
        )
    }

}

@Composable
@Preview("not completed", showBackground = true)
fun StepItemPreview1() {
    AppTheme {
        StepItem(
            model = StepItemUiModel(
                step = 0,
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
                step = 0,
                label = "Bepaal je maximale harstlag",
                description = "Om gezond te sporten is het van cruciaal belang je harstlag te volgen. Hier bepalen we eerst je maximale harstlag.",
                completed = true,
            )
        )
    }
}

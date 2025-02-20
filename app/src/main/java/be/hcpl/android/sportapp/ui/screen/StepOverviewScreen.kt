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
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.AppTypography

// TODO literals

@Composable
fun StepOverviewScreen() {
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
    }
}

@Composable
@Preview(showBackground = true)
fun StepOverviewScreenPreview() {
    AppTheme {
        StepOverviewScreen()
    }
}
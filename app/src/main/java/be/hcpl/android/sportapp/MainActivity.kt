package be.hcpl.android.sportapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.AppTypography

class MainActivity : ComponentActivity() {

    // TODO add a ViewModel here for all the logic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                    .fillMaxHeight()
                    .padding(16.dp)
                ) {
                    item {
                        Text(text = "Welkom sporter", style = AppTypography.headlineLarge)
                        Text(
                            style = AppTypography.bodyLarge,
                            text = "Volg onderstaande stappenplan om gezond en verantwoord te sporten op basis van je hartslag.")
                    }
                }
            }

        }
    }
}
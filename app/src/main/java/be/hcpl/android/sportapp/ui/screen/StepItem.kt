package be.hcpl.android.sportapp.ui.screen

import be.hcpl.android.sportapp.R

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import be.hcpl.android.sportapp.ui.model.StepItemUiModel
import be.hcpl.android.sportapp.ui.theme.AppTheme
import be.hcpl.android.sportapp.ui.theme.AppTypography
import be.hcpl.android.sportapp.ui.theme.primaryDark
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
                //.dashedBorder(1.dp, 16.dp, color = primaryDark)
                .padding(16.dp)
                //.clickable(
                //    onClick = { onSelect() }
                //)
        ) {
            Text(
                style = AppTypography.titleLarge,
                text = model.label,
                color = primaryLight,
            )
            Text(
                style = AppTypography.bodyLarge,
                text = model.description,
                color = tertiaryLight,
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
            tint = Color.Green,
            contentDescription = stringResource(id = R.string.content_description_checked),
        )
}

fun Modifier.dashedBorder(width: Dp, radius: Dp, color: Color) =
    drawBehind {
        drawIntoCanvas {
            val paint = Paint()
                .apply {
                    strokeWidth = width.toPx()
                    this.color = color
                    style = PaintingStyle.Stroke
                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                }
            it.drawRoundRect(
                width.toPx(),
                width.toPx(),
                size.width - width.toPx(),
                size.height - width.toPx(),
                radius.toPx(),
                radius.toPx(),
                paint
            )
        }
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

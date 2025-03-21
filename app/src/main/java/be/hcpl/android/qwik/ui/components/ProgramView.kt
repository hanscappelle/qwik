package be.hcpl.android.qwik.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.domain.model.Block
import be.hcpl.android.qwik.domain.model.Program
import be.hcpl.android.qwik.domain.model.RateZone
import be.hcpl.android.qwik.ui.model.ProgramUiModel
import be.hcpl.android.qwik.ui.theme.AppTheme
import be.hcpl.android.qwik.ui.theme.AppTypography
import be.hcpl.android.qwik.ui.theme.inverseOnSurfaceDark
import be.hcpl.android.qwik.ui.theme.inverseOnSurfaceLight
import be.hcpl.android.qwik.ui.theme.inverseSurfaceDark
import be.hcpl.android.qwik.ui.theme.inverseSurfaceLight
import be.hcpl.android.qwik.ui.theme.secondaryLight

@Composable
fun ProgramView(
    model: ProgramUiModel,
    modifier: Modifier = Modifier,
) {

    val headerBackground = if (isSystemInDarkTheme()) inverseSurfaceDark else inverseSurfaceLight
    val headerText = if (isSystemInDarkTheme()) inverseOnSurfaceDark else inverseOnSurfaceLight

    Column(
        modifier = modifier
            .border(border = BorderStroke(1.dp, secondaryLight)),
    ) {
        TitleBold(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = headerBackground)
                .padding(horizontal = 8.dp),
            style = AppTypography.titleLarge.copy(color = headerText),
            text = "${model.program.title} (total ${model.program.blocks.map { it.repeats * it.durationMin }.sum()} min)"
        )

        model.program.blocks.forEachIndexed { index, block ->
            if (index == 0)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = secondaryLight,
                )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp),
                    text = "${block.repeats}x"
                )
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = 8.dp),
                    text = block.description
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                    ,
                    textAlign = TextAlign.Center,
                    text = "${block.zone}"
                )
                Text(
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .width(75.dp)
                    ,
                    textAlign = TextAlign.End,
                    text = "${block.durationMin} min"
                )
            }
            if (index < model.program.blocks.size - 1)
                HorizontalDivider(
                    thickness = 1.dp,
                    color = secondaryLight,
                )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgramViewPreview() {
    AppTheme {
        ProgramView(
            ProgramUiModel(
                program = Program(
                    title = "Test Training",
                    blocks = listOf(
                        Block(repeats = 1, "warm up", zone = RateZone.D0, durationMin = 20),
                        Block(4, "fast", zone = RateZone.D2, durationMin = 5),
                        Block(4, "slow", zone = RateZone.D1, durationMin = 5),
                        Block(1, "cool down", zone = RateZone.D0, durationMin = 120),
                    )
                )
            )
        )

    }
}
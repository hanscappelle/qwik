package be.hcpl.android.qwik.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.hcpl.android.qwik.domain.model.StepPosition
import be.hcpl.android.qwik.ui.components.Body
import be.hcpl.android.qwik.ui.components.HeadLine
import be.hcpl.android.qwik.ui.components.StepItem
import be.hcpl.android.qwik.ui.model.OverviewUiModel
import be.hcpl.android.qwik.ui.model.StepItemUiModel
import be.hcpl.android.qwik.ui.theme.AppTheme

@Composable
fun StepOverviewScreen(
    model: OverviewUiModel?,
    onSelect: (StepPosition) -> Unit,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        item {
            HeadLine(text = model?.welcomeTitle.orEmpty())
            Body(text = model?.welcomeText.orEmpty())
        }
        model?.steps?.forEach {
            item {
                StepItem(model = it, onSelect = { onSelect.invoke(it.step) })
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
                    StepItemUiModel(StepPosition.NOT_SET, "step1", "description", true),
                    StepItemUiModel(StepPosition.MAX_HART_RATE, "step2", "description", false),
                    StepItemUiModel(StepPosition.VISUALISE_ZONES, "step3", "description", false),
                ),
            ),
            onSelect = {},
        )
    }
}
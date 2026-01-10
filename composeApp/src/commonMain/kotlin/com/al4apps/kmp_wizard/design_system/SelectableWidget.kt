package com.al4apps.kmp_wizard.design_system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.SelectableDates
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.al4apps.kmp_wizard.shared_models.SelectableWidgetState
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_check
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@Composable
fun SelectableWidget(state: SelectableWidgetState) {
    Card(
        modifier = Modifier.size(36.dp),
        shape = CircleShape
    ) {
        if (state.isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LAppTheme.colors.background.primary),
                contentAlignment = Alignment.Center
            ) {
                val icon = state.icon ?: Res.drawable.ic_check
                Icon(
                    imageVector = vectorResource(icon),
                    contentDescription = null,
                    tint = LAppTheme.colors.icon.white
                )
            }
        }
    }
}

@Composable
fun SelectableWidget(isSelected: Boolean) {
    Card(
        modifier = Modifier.size(36.dp),
        shape = CircleShape
    ) {
        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LAppTheme.colors.background.primary),
                contentAlignment = Alignment.Center
            ) {
                val icon = Res.drawable.ic_check
                Icon(
                    imageVector = vectorResource(icon),
                    contentDescription = null,
                    tint = LAppTheme.colors.icon.white
                )
            }
        }
    }
}

@Composable
@Preview
fun SelectableWidgetPreview() {
    SelectableWidget(SelectableWidgetState.INITIAL)
}
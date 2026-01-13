package com.al4apps.kmp_wizard.design_system

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_check
import kmpwizardproject.composeapp.generated.resources.ic_favorite_selected
import kmpwizardproject.composeapp.generated.resources.ic_play
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@Composable
fun SelectableWidget(
    isSelected: Boolean,
    modifier: Modifier = Modifier,
    iconRes: DrawableResource? = null,
    onClicked: () -> Unit = {}
) {
    Card(
        modifier = modifier.size(36.dp),
        shape = CircleShape
    ) {
        if (isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(LAppTheme.colors.background.primary),
                contentAlignment = Alignment.Center
            ) {
                val icon = iconRes ?: Res.drawable.ic_check
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
fun IconWidget(
    modifier: Modifier = Modifier,
    iconRes: DrawableResource,
    onClicked: () -> Unit = {}
) {
        Box(
            modifier = modifier,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = vectorResource(iconRes),
                contentDescription = null,
                tint = LAppTheme.colors.icon.success
            )
        }

}

@Composable
@Preview
fun SelectableWidgetPreview() {
//    SelectableWidget(true)
    IconWidget(iconRes = Res.drawable.ic_favorite_selected)
}
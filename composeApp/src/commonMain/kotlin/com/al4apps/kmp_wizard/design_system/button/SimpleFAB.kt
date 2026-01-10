package com.al4apps.kmp_wizard.design_system.button

import androidx.compose.foundation.Image
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.vectorResource
import ru.expasoft.digitalpictureframe.theme.LAppTheme

@Composable
fun SimpleFAB(
    vectorRes: DrawableResource? = null,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = { onClick() },
        modifier = modifier,
        shape = Shapes().extraLarge,
        containerColor = LAppTheme.colors.button.primary,
    ) {
        vectorRes?.let {
            Image(
                vectorResource(vectorRes),
                contentDescription = null,
            )
        }
    }
}
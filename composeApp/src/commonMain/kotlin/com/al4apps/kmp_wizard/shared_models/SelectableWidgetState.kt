package com.al4apps.kmp_wizard.shared_models

import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_check
import org.jetbrains.compose.resources.DrawableResource

data class SelectableWidgetState(
    val icon: DrawableResource?,
    val isSelected: Boolean
) {
    companion object {
        val INITIAL = SelectableWidgetState(
            icon = Res.drawable.ic_check,
            isSelected = false
        )
    }
}

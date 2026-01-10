package com.al4apps.kmp_wizard.shared_models

import org.jetbrains.compose.resources.DrawableResource

data class TopBarUiState(
    val title: String,
    val navIcon: DrawableResource?,
    val selectableWidgetState: SelectableWidgetState?,
    val actionIcon: DrawableResource?,
    val isActionIconClickable: Boolean,
) {

    companion object {
        val INITIAL = TopBarUiState(
            title = "ListApp",
            navIcon = null,
            selectableWidgetState = null,
            actionIcon = null,
            isActionIconClickable = false,
        )
    }
}

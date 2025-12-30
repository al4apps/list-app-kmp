package com.al4apps.kmp_wizard.shared_models

import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.stringResource

data class TopBarUiState(
    val title: String,
    val navIcon: DrawableResource? = null,
    val actionIcon: DrawableResource? = null,
    val isActionIconClickable: Boolean = true,
) {

    companion object {
        val INITIAL = TopBarUiState(
            "ListApp"
        )
    }
}

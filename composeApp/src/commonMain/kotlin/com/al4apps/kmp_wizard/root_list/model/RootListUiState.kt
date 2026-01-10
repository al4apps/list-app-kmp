package com.al4apps.kmp_wizard.root_list.model

import com.al4apps.kmp_wizard.shared_models.TopBarUiState
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class RootListUiState(
    val list: ImmutableList<RootListItemUiModel>,
    val topBarUiState: TopBarUiState,
    val isInSelectionMode: Boolean,
    val isAllSelected: Boolean,
    val isLoading: Boolean
) {
    companion object {
        val INITIAL = RootListUiState(
            list = persistentListOf(),
            topBarUiState = TopBarUiState.INITIAL,
            isInSelectionMode = false,
            isAllSelected = false,
            isLoading = false
        )
    }
}
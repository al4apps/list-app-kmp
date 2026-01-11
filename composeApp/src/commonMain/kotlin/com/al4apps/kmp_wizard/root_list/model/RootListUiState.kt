package com.al4apps.kmp_wizard.root_list.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class RootListUiState(
    val list: ImmutableList<RootListItemUiModel>,
    val isInSelectionMode: Boolean,
    val isAllSelected: Boolean,
    val isLoading: Boolean
) {
    companion object {
        val INITIAL = RootListUiState(
            list = persistentListOf(),
            isInSelectionMode = false,
            isAllSelected = false,
            isLoading = false
        )
    }
}
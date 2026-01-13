package com.al4apps.kmp_wizard.list.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class ChildListUiState(
    val rootListTitle: String,
    val items: ImmutableList<ChildListItemUi>,
    val isInSelectionMode: Boolean,
    val isAllSelected: Boolean,
    val showDeleteDialog: Boolean,
    val isLoading: Boolean,
    val bottomBarState: BottomBarState? = null
) {
    companion object {
        val INITIAL = ChildListUiState(
            rootListTitle = "List 23",
            items = persistentListOf(),
            isInSelectionMode = false,
            isAllSelected = false,
            isLoading = false,
            showDeleteDialog = false,
            bottomBarState = null
        )
    }
}

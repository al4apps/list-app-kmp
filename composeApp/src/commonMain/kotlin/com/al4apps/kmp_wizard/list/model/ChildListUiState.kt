package com.al4apps.kmp_wizard.list.model

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf

data class ChildListUiState(
    val rootListId: Int,
    val rootListTitle: String,
    val items: ImmutableList<ChildListItemUi>,
    val isInSelectionMode: Boolean,
    val isAllSelected: Boolean,
    val isLoading: Boolean,
    val bottomBarState: BottomBarState? = null
) {
    companion object {
        val INITIAL = ChildListUiState(
            rootListId = 0,
            rootListTitle = "List 23",
            items = persistentListOf(),
            isInSelectionMode = false,
            isAllSelected = false,
            isLoading = false,
            bottomBarState = null
        )
    }
}

package com.al4apps.kmp_wizard.list.model

import com.al4apps.kmp_wizard.utils.childListItemsSample
import kotlinx.serialization.Serializable

@Serializable
data class ChildListVmState(
    val rootListId: Int,
    val rootListTitle: String,
    val items: List<ChildListItem>,
    val isInSelectionMode: Boolean,
    val isAllSelected: Boolean,
    val isLoading: Boolean,
    val showDeleteDialog: Boolean = false,
    val enableDeleteConfirmation: Boolean = true,
    val bottomBarState: BottomBarState? = null
) {
    companion object {
        val INITIAL = ChildListVmState(
            rootListId = 0,
            rootListTitle = "List",
            items = listOf(),
            isInSelectionMode = false,
            isAllSelected = false,
            isLoading = false,
            showDeleteDialog = false,
            enableDeleteConfirmation = true,
            bottomBarState = null
        )
        val SAMPLE = INITIAL.copy(items = childListItemsSample)
    }
}

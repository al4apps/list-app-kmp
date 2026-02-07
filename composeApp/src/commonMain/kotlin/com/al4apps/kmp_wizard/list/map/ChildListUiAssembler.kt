package com.al4apps.kmp_wizard.list.map

import com.al4apps.kmp_wizard.list.model.ChildListItem
import com.al4apps.kmp_wizard.list.model.ChildListItemUi
import com.al4apps.kmp_wizard.list.model.ChildListUiState
import com.al4apps.kmp_wizard.list.model.ChildListVmState
import com.al4apps.kmp_wizard.list.model.ExpandableFields
import kotlinx.collections.immutable.toImmutableList

class ChildListUiAssembler {

    fun assembleToUi(state: ChildListVmState): ChildListUiState {
        return ChildListUiState(
            rootListTitle = state.rootListTitle,
            items = state.items.map { item ->
                toUiItem(item)
            }.toImmutableList(),
            isInSelectionMode = state.isInSelectionMode,
            isAllSelected = state.items.all { it.isSelected },
            isLoading = state.isLoading,
            showDeleteDialog = state.showDeleteDialog,
            bottomBarState = state.bottomBarState
        )
    }

    private fun toUiItem(item: ChildListItem): ChildListItemUi {
        return ChildListItemUi(
            id = item.id,
            title = item.title,
            value = item.mValue,
            fields = item.fields,
            icon = null,
            comment = item.comment,
            isSelected = item.isSelected,
            isExpandedBottom = item.isExpandedValues || item.isExpandedActions,
            expandableInfo = if (item.fields.isNotEmpty()) ExpandableFields else null,
        )
    }
}

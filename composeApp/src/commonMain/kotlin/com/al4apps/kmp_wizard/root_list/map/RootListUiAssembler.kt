package com.al4apps.kmp_wizard.root_list.map

import com.al4apps.kmp_wizard.root_list.model.RootListItem
import com.al4apps.kmp_wizard.root_list.model.RootListItemUiModel
import com.al4apps.kmp_wizard.root_list.model.RootListUiState
import com.al4apps.kmp_wizard.root_list.model.RootListVmState
import kotlinx.collections.immutable.toImmutableList

class RootListUiAssembler {

    fun assembleToUi(vmState: RootListVmState): RootListUiState {
        val items = vmState.list.map { it.toUiItem() }

        return RootListUiState(
            list = items.toImmutableList(),
            isInSelectionMode = vmState.isInSelectionMode,
            isAllSelected = vmState.list.all { it.isSelected },
            isLoading = false
        )
    }
    private fun RootListItem.toUiItem(): RootListItemUiModel {
        return RootListItemUiModel(
            id = id,
            title = title,
            date = date,
            isSelected = isSelected,
        )
    }
}

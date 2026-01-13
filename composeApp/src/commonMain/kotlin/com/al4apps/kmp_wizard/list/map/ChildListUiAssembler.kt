package com.al4apps.kmp_wizard.list.map

import com.al4apps.kmp_wizard.list.model.ChildListItem
import com.al4apps.kmp_wizard.list.model.ChildListItemUi
import com.al4apps.kmp_wizard.list.model.ChildListUiState
import com.al4apps.kmp_wizard.list.model.ChildListVmState
import com.al4apps.kmp_wizard.list.model.ItemIcon
import com.al4apps.kmp_wizard.list.model.ItemMark
import com.al4apps.kmp_wizard.list.model.NumberValue
import com.al4apps.kmp_wizard.list.model.StringValue
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_blizzard
import kmpwizardproject.composeapp.generated.resources.ic_check
import kmpwizardproject.composeapp.generated.resources.ic_favorite_selected
import kmpwizardproject.composeapp.generated.resources.ic_minus
import kmpwizardproject.composeapp.generated.resources.ic_plus
import kotlinx.collections.immutable.toImmutableList

class ChildListUiAssembler {

    fun assembleToUi(state: ChildListVmState): ChildListUiState {
        return ChildListUiState(
            rootListTitle = state.rootListTitle,
            items = state.items.map { item ->
                toUiItem(item)
            }.toImmutableList(),
            isInSelectionMode = state.isInSelectionMode,
            isAllSelected = state.isAllSelected,
            isLoading = state.isLoading,
            showDeleteDialog = state.showDeleteDialog,
            bottomBarState = state.bottomBarState
        )
    }

    private fun toUiItem(item: ChildListItem): ChildListItemUi {
        val itemValue = when (item.value) {
            is NumberValue -> item.value.number.toString()
            is StringValue -> item.value.text
        }
        val markIcon = when (item.markIcon) {
            ItemMark.NONE -> null
            ItemMark.CHECKED -> Res.drawable.ic_check
            ItemMark.STAR -> Res.drawable.ic_plus
            ItemMark.LIKE -> Res.drawable.ic_favorite_selected
            ItemMark.BRICK -> Res.drawable.ic_minus
        }

        return ChildListItemUi(
            id = item.id,
            title = item.title,
            value = itemValue,
            icon = null,
            subtitle = item.subtitle,
            comment = item.comment,
            isSelected = item.isSelected,
            markIcon = markIcon,
            isExpandedBottom = item.isExpandedValues || item.isExpandedActions,
        )
    }
}
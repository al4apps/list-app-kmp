package com.al4apps.kmp_wizard.root_list

import com.al4apps.kmp_wizard.root_list.model.RootListItemUiModel
import com.al4apps.kmp_wizard.root_list.model.RootListUiState
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kotlinx.collections.immutable.toImmutableList

class PreviewRootListComponent : RootListComponent {
    override val uiState: Value<RootListUiState> = MutableValue(
        RootListUiState.INITIAL.copy(
            list = listOf(
                RootListItemUiModel.INITIAL,
                RootListItemUiModel.INITIAL.copy(isSelected = true),
                RootListItemUiModel.INITIAL,
                RootListItemUiModel.INITIAL,
                RootListItemUiModel.INITIAL.copy(isSelected = true),
                RootListItemUiModel.INITIAL,
                RootListItemUiModel.INITIAL,
                RootListItemUiModel.INITIAL.copy(isSelected = true),
                RootListItemUiModel.INITIAL,
                RootListItemUiModel.INITIAL,
                RootListItemUiModel.INITIAL.copy(isSelected = true),
                RootListItemUiModel.INITIAL,
            ).toImmutableList(),
            isInSelectionMode = true,
        )
    )

    override fun onItemClick(id: Int) {}

    override fun onItemLongClick(id: Int) {}

    override fun onSelectAllClicked() {}
}
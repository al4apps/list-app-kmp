package com.al4apps.kmp_wizard.root_list

import androidx.compose.runtime.Composable
import com.al4apps.kmp_wizard.root_list.model.RootListItemUiModel
import com.al4apps.kmp_wizard.root_list.model.RootListUiState
import com.al4apps.kmp_wizard.shared_models.SelectableWidgetState
import com.al4apps.kmp_wizard.shared_models.TopBarUiState
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import kmpwizardproject.composeapp.generated.resources.Res
import kmpwizardproject.composeapp.generated.resources.ic_check
import kotlinx.collections.immutable.toImmutableList

class PreviewRootListComponent : RootListComponent {
    override val uiState: Value<RootListUiState> = MutableValue(RootListUiState.INITIAL.copy(
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
        topBarUiState = TopBarUiState.INITIAL.copy(
            title = "Мои списки",
            selectableWidgetState = SelectableWidgetState.INITIAL.copy(isSelected = false),
        )
    ))

    override fun onItemClick(id: Int) {}

    override fun onItemLongClick(id: Int) {}

    override fun onSelectAllClicked() {}
}
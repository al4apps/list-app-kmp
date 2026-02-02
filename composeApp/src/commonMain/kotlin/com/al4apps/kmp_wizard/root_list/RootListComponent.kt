package com.al4apps.kmp_wizard.root_list

import com.al4apps.kmp_wizard.root_list.model.RootListUiState
import com.arkivanov.decompose.value.Value

interface RootListComponent {
    val uiState: Value<RootListUiState>

    fun onItemClick(id: Int)
    fun onItemLongClick(id: Int)
    fun onSelectAllClicked()
    fun onAddNewListClicked()
}
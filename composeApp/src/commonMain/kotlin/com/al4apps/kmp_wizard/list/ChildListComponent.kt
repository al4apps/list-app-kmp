package com.al4apps.kmp_wizard.list

import com.al4apps.kmp_wizard.list.model.ChildListUiState
import com.arkivanov.decompose.value.Value

interface ChildListComponent {

    val uiState: Value<ChildListUiState>

    fun onBackClicked()
    fun onSelectAllClicked()
}
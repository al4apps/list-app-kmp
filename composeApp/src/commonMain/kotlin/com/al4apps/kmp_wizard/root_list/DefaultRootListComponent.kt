package com.al4apps.kmp_wizard.root_list

import com.al4apps.kmp_wizard.root_list.model.RootListUiState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class DefaultRootListComponent(
    componentContext: ComponentContext
) : RootListComponent, ComponentContext by componentContext {

    override val uiState: Value<RootListUiState> = MutableValue(RootListUiState.INITIAL)

    override fun onItemClick(id: Int) {
    }

    override fun onItemLongClick(id: Int) {
    }

    override fun onSelectAllClicked() {
    }

}
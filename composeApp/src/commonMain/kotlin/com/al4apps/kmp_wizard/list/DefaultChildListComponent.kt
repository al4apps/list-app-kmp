package com.al4apps.kmp_wizard.list

import com.al4apps.kmp_wizard.core.CoroutineFeature
import com.al4apps.kmp_wizard.core.CoroutineFeatureImpl
import com.al4apps.kmp_wizard.list.model.ChildListUiState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class DefaultChildListComponent(
    componentContext: ComponentContext,
    private val onBackClick: () -> Unit,
) : ChildListComponent, ComponentContext by componentContext,
    CoroutineFeature by CoroutineFeatureImpl(componentContext) {

    override val uiState: Value<ChildListUiState> = MutableValue(ChildListUiState.INITIAL)

    override fun onBackClicked() {
        this.onBackClick()
    }

    override fun onSelectAllClicked() {
    }
}
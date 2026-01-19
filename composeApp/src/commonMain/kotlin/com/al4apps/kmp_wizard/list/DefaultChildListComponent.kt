package com.al4apps.kmp_wizard.list

import com.al4apps.kmp_wizard.core.CoroutineFeature
import com.al4apps.kmp_wizard.core.CoroutineFeatureImpl
import com.al4apps.kmp_wizard.core.StateStore
import com.al4apps.kmp_wizard.core.toUiSate
import com.al4apps.kmp_wizard.list.map.ChildListUiAssembler
import com.al4apps.kmp_wizard.list.model.ChildListUiState
import com.al4apps.kmp_wizard.list.model.ChildListVmState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value

class DefaultChildListComponent(
    componentContext: ComponentContext,
    private val onBackClick: () -> Unit,
    assembler: ChildListUiAssembler = ChildListUiAssembler(),
) : ChildListComponent, ComponentContext by componentContext,
    CoroutineFeature by CoroutineFeatureImpl(componentContext) {

    private val preservedListState =
        stateKeeper.consume(STATE_LIST_KEY, ChildListVmState.serializer())
            ?: ChildListVmState.SAMPLE

    private val vmState = StateStore(preservedListState)
    override val uiState: Value<ChildListUiState> = vmState.toUiSate(featureScope, assembler::assembleToUi)

    override fun onBackClicked() {
        this.onBackClick()
    }

    override fun onSelectAllClicked() {
    }

    companion object {
        private const val STATE_LIST_KEY = "state_child_list"
    }
}
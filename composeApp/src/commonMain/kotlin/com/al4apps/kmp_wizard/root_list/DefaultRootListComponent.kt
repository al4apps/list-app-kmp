package com.al4apps.kmp_wizard.root_list

import com.al4apps.kmp_wizard.core.CoroutineFeature
import com.al4apps.kmp_wizard.core.CoroutineFeatureImpl
import com.al4apps.kmp_wizard.core.StateStore
import com.al4apps.kmp_wizard.core.toUiSate
import com.al4apps.kmp_wizard.logMessage
import com.al4apps.kmp_wizard.root_list.map.RootListUiAssembler
import com.al4apps.kmp_wizard.root_list.model.RootListUiState
import com.al4apps.kmp_wizard.root_list.model.RootListVmState
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value

class DefaultRootListComponent(
    componentContext: ComponentContext,
    private val onItemClicked: (Int) -> Unit,
    assembler: RootListUiAssembler = RootListUiAssembler(),
) : RootListComponent, ComponentContext by componentContext,
    CoroutineFeature by CoroutineFeatureImpl(componentContext) {

    private val preservedListState = stateKeeper.consume(
        key = STATE_LIST_KEY,
        strategy = RootListVmState.serializer()
    ) ?: RootListVmState.sample

    private val vmState = StateStore(preservedListState)
    override val uiState: Value<RootListUiState> = vmState.toUiSate(
        scope = featureScope,
        assemble = assembler::assembleToUi
    )

    override fun onItemClick(id: Int) {

        if (vmState.value.isInSelectionMode()) {
            updateStateWithSelectedItem(id)
        } else {
            onItemClicked(id)
        }
    }

    override fun onItemLongClick(id: Int) {
        if (vmState.value.isInSelectionMode()) return
        updateStateWithSelectedItem(id)
    }

    private fun updateStateWithSelectedItem(id: Int) {
        vmState.updateState { state ->
            val updated = state.list.map { item ->
                if (item.id == id) item.copy(isSelected = !item.isSelected)
                else item
            }
            state.copy(list = updated)
        }
    }

    override fun onSelectAllClicked() {
        vmState.updateState { state ->
            val isAllSelected = state.list.all { it.isSelected }
            state.copy(list = state.list.map { it.copy(isSelected = !isAllSelected) })
        }
    }

    companion object {
        private const val STATE_LIST_KEY = "state_list"
    }
}